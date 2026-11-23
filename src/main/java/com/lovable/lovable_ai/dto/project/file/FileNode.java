package com.lovable.lovable_ai.dto.project.file;

import java.time.Instant;

public record FileNode (
        String path,
        Instant createdAt,
        Long size,
        String type
){
}
