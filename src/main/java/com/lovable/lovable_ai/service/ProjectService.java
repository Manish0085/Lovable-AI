package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.project.ProjectProjectSummaryResponse;
import com.lovable.lovable_ai.dto.project.ProjectRequest;
import com.lovable.lovable_ai.dto.project.ProjectResponse;

import java.util.List;
import java.util.UUID;

public interface ProjectService {
    List<ProjectProjectSummaryResponse> getUserProjects(UUID userId);

    ProjectResponse getUserProjectById(UUID id, UUID userId);

    ProjectResponse createProject(ProjectRequest request, UUID userId);

    ProjectResponse updateProject(UUID id, ProjectRequest request, UUID userId);


    void softDelete(UUID id, UUID userId);
}
