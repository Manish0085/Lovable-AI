package com.lovable.lovable_ai.mapper;


import com.lovable.lovable_ai.dto.project.ProjectSummaryResponse;
import com.lovable.lovable_ai.dto.project.ProjectResponse;
import com.lovable.lovable_ai.entity.Project;

//@Mapper
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
    ProjectSummaryResponse toProjectProjectSummaryResponse(Project project);
}
