package com.lovable.lovable_ai.controller;

import com.lovable.lovable_ai.dto.project.file.FileContentResponse;
import com.lovable.lovable_ai.dto.project.file.FileNode;
import com.lovable.lovable_ai.dto.project.file.FileTreeResponse;
import com.lovable.lovable_ai.service.FileService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Validated
public class FileController {

    FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable UUID projectId) {
        UUID userID = UUID.randomUUID();
        return ResponseEntity.ok(fileService.getFileTree(projectId, userID));
    }

    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFile(@PathVariable UUID projectId, @PathVariable String path) {
        UUID userID = UUID.randomUUID();
        return ResponseEntity.ok(fileService.getFileContent(projectId, path, userID));
    }
}
