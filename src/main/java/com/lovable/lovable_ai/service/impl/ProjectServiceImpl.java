package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.member.InviteMemberRequest;
import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.dto.member.UpdateMemberRoleRequest;
import com.lovable.lovable_ai.dto.project.ProjectProjectSummaryResponse;
import com.lovable.lovable_ai.dto.project.ProjectRequest;
import com.lovable.lovable_ai.dto.project.ProjectResponse;
import com.lovable.lovable_ai.entity.Project;
import com.lovable.lovable_ai.entity.User;
import com.lovable.lovable_ai.mapper.ProjectMapper;
import com.lovable.lovable_ai.repository.ProjectRepository;
import com.lovable.lovable_ai.repository.UserRepository;
import com.lovable.lovable_ai.service.ProjectMemberService;
import com.lovable.lovable_ai.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

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

    @Override
    public ProjectResponse createProject(ProjectRequest request, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();

        Project project = Project.builder()
                .name(request.name())
                .owner(user)
                .isPublic(false)
                .build();

        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectProjectSummaryResponse> getUserProjects(UUID userId) {
        return projectRepository.findAllAccessibleByUser(userId)
                .stream()
                .map(projectMapper::toProjectProjectSummaryResponse)
                .toList();

    }

    @Override
    public ProjectResponse getUserProjectById(UUID id, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();

        Project project = projectRepository.findByUserId(userId);
        return projectMapper.toProjectResponse(project);
    }


    @Override
    public ProjectResponse updateProject(UUID id, ProjectRequest request, UUID userId) {

    }

    @Override
    public void softDelete(UUID id, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();


    }
}
