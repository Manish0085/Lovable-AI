package com.lovable.lovable_ai.controller;

import com.lovable.lovable_ai.dto.project.ProjectProjectSummaryResponse;
import com.lovable.lovable_ai.dto.project.ProjectRequest;
import com.lovable.lovable_ai.dto.project.ProjectResponse;
import com.lovable.lovable_ai.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects/")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectProjectSummaryResponse>> getMyProjects() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable UUID id) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(projectService.getUserProjectById(id, userId));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> getProjectById(@RequestBody ProjectRequest request) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request, userId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable UUID id, @RequestBody ProjectRequest request) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.updateProject(id, request, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID id) {
        UUID userId = UUID.randomUUID();
        projectService.softDelete(id, userId);
        return ResponseEntity.noContent().build();
    }
}
