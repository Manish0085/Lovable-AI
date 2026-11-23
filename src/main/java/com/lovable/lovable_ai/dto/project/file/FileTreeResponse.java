package com.lovable.lovable_ai.dto.project.file;

import java.util.List;

public record FileTreeResponse(
        List<FileNode> files
) {
}
