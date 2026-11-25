package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.project.ProjectSummaryResponse;
import com.lovable.lovable_ai.dto.project.ProjectRequest;
import com.lovable.lovable_ai.dto.project.ProjectResponse;

import java.util.List;
import java.util.UUID;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getUserProjectById(UUID id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(UUID id, ProjectRequest request);


    void softDelete(UUID id);
}
