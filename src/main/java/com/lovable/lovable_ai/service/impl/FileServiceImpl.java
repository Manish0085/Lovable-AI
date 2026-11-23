package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.project.file.FileContentResponse;
import com.lovable.lovable_ai.dto.project.file.FileNode;
import com.lovable.lovable_ai.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(UUID projectId, UUID userID) {
        return null;
    }

    @Override
    public FileContentResponse getFileContent(UUID projectId, String path, UUID userId) {
        return null;
    }
}
