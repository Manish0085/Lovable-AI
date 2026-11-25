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
import com.lovable.lovable_ai.security.AuthUtil;
import com.lovable.lovable_ai.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
@Slf4j
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    UserRepository userRepository;
    AuthUtil authUtil;

    ProjectMemberMapper projectMemberMapper;
    @Override
    public List<MemberResponse> getProjectMembers(UUID projectId) {
        UUID userId = authUtil.getCurrentUserId();
         Project project = getAccessibleProjectById(projectId, userId);
         List<MemberResponse> memberResponseList = new ArrayList<>();

        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();
    }

    @Override
    public MemberResponse inviteMember(UUID projectId, InviteMemberRequest request) {
        UUID userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);


        User invitee = userRepository.findByUsername(request.username())
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
    public MemberResponse updateMemberRole(UUID projectId, UUID memberId, UpdateMemberRoleRequest request) {
        UUID userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);



        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, userId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId)
                .orElseThrow();

        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(UUID projectId) {
        UUID userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, userId);
        if (!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Member not found in project");
        }

        projectMemberRepository.deleteById(projectMemberId);


    }

    private Project getAccessibleProjectById(UUID projectId, UUID userId) {
//        UUID userId = authUtil.getCurrentUserId();
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow();
    }
}
