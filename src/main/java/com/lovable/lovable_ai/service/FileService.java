package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.project.file.FileContentResponse;
import com.lovable.lovable_ai.dto.project.file.FileNode;

import java.util.List;
import java.util.UUID;

public interface FileService {
    List<FileNode> getFileTree(UUID projectId, UUID userID);

    FileContentResponse getFileContent(UUID projectId, String path, UUID userId);
}
