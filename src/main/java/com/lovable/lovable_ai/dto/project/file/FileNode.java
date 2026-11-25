package com.lovable.lovable_ai.dto.project.file;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "A single entry (file or folder) in a project's file tree")
public record FileNode(

        @Schema(
                description = "Path of the entry relative to the project root, using forward slashes",
                example = "src/components/Header.jsx",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String path,

        @Schema(
                description = "Timestamp (UTC, ISO-8601) of when the entry was created",
                example = "2026-11-25T10:15:30Z",
                type = "string",
                format = "date-time",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Instant createdAt,

        @Schema(
                description = "Size of the file in bytes. Null or 0 for folders",
                example = "2048",
                minimum = "0",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                nullable = true
        )
        Long size,

        @Schema(
                description = "Kind of entry",
                example = "FILE",
                allowableValues = {"FILE", "DIRECTORY"},
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String type
) {
}