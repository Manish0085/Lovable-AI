package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.member.InviteMemberRequest;
import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.dto.member.UpdateMemberRoleRequest;
import com.lovable.lovable_ai.entity.Project;
import com.lovable.lovable_ai.entity.ProjectMember;
import com.lovable.lovable_ai.entity.ProjectMemberId;
import com.lovable.lovable_ai.entity.User;
import com.lovable.lovable_ai.mapper.ProjectMemberMapper;
import com.lovable.lovable_ai.repository.ProjectMemberRepository;
import com.lovable.lovable_ai.repository.ProjectRepository;
import com.lovable.lovable_ai.repository.UserRepository;
import com.lovable.lovable_ai.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    UserRepository userRepository;

    ProjectMemberMapper projectMemberMapper;
    @Override
    public List<MemberResponse> getProjectMembers(UUID projectId, UUID userId) {
         Project project = getAccessibleProjectById(projectId, userId);
         List<MemberResponse> memberResponseList = new ArrayList<>();
         memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponseList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList()
        );
        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(UUID projectId, InviteMemberRequest request, UUID userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        if (project.getOwner().getId().equals(projectId)) {
            throw new RuntimeException("Not Allowed")
        }

        User invitee = userRepository.findByEmail(request.email())
                .orElseThrow();

        if (invitee.getId() == userId)
            throw new RuntimeException("Cannot invite to self");

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());
        if (projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Cannot invite again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
//                .invitedBy()
                .build();

        projectMemberRepository.save(member);
        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(UUID projectId, UpdateMemberRoleRequest request, UUID userId) {
        return null;
    }

    @Override
    public void deleteProjectMember(UUID projectId, UUID userId) {

    }

    private Project getAccessibleProjectById(UUID projectId, UUID userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow();
    }
}
