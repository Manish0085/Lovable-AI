package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.constants.ProjectRole;
import com.lovable.lovable_ai.dto.member.InviteMemberRequest;
import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.dto.member.UpdateMemberRoleRequest;
import com.lovable.lovable_ai.dto.project.ProjectSummaryResponse;
import com.lovable.lovable_ai.dto.project.ProjectRequest;
import com.lovable.lovable_ai.dto.project.ProjectResponse;
import com.lovable.lovable_ai.entity.Project;
import com.lovable.lovable_ai.entity.ProjectMember;
import com.lovable.lovable_ai.entity.ProjectMemberId;
import com.lovable.lovable_ai.entity.User;
import com.lovable.lovable_ai.exception.ResourceNotFoundException;
import com.lovable.lovable_ai.mapper.ProjectMapper;
import com.lovable.lovable_ai.repository.ProjectMemberRepository;
import com.lovable.lovable_ai.repository.ProjectRepository;
import com.lovable.lovable_ai.repository.UserRepository;
import com.lovable.lovable_ai.service.ProjectMemberService;
import com.lovable.lovable_ai.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest request, UUID userId) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("USER_ID", userId.toString()));

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .invitedBy(owner.getUsername())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);


        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(UUID userId) {
        return projectRepository.findAllAccessibleByUser(userId)
                .stream()
                .map(projectMapper::toProjectProjectSummaryResponse)
                .toList();

    }

    @Override
    public ProjectResponse getUserProjectById(UUID id, UUID userId) {
        Project project = getAccessibleProjectById(id, userId);

        return projectMapper.toProjectResponse(project);
    }


    @Override
    public ProjectResponse updateProject(UUID id, ProjectRequest request, UUID userId) {
        Project project = getAccessibleProjectById(id, userId);

        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(UUID id, UUID userId) {
        Project project = getAccessibleProjectById(id, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    private Project getAccessibleProjectById(UUID projectId, UUID userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("PROJECT", projectId.toString()));
    }
}
