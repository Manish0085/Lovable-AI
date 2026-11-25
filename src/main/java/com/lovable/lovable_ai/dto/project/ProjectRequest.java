package com.lovable.lovable_ai.dto.project;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Request payload for creating or renaming a project")
public record ProjectRequest(

        @Schema(
                description = "Name of the project",
                example = "My Portfolio Website",
                requiredMode = Schema.RequiredMode.REQUIRED,
                minLength = 1,
                maxLength = 100
        )
        @NotBlank(message = "Project name is required")
        @Size(max = 100, message = "Project name must not exceed 100 characters")
        String name
) {
}