package com.lovable.lovable_ai.dto.project.file;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The path and text content of a single file within a project")
public record FileContentResponse(

        @Schema(
                description = "Path of the file relative to the project root, using forward slashes",
                example = "src/components/Header.jsx",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String path,

        @Schema(
                description = "Full text content of the file. Empty string if the file is empty",
                example = "export default function Header() {\n  return <h1>Hello</h1>;\n}",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String content
) {
}