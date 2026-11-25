package com.lovable.lovable_ai.dto.project.file;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "The file tree of a project, listing the files and folders it contains")
public record FileTreeResponse(

        @ArraySchema(
                arraySchema = @Schema(
                        description = "Files and folders in the project. Empty list if the project has no files",
                        requiredMode = Schema.RequiredMode.REQUIRED
                ),
                schema = @Schema(implementation = FileNode.class)
        )
        List<FileNode> files
) {
}