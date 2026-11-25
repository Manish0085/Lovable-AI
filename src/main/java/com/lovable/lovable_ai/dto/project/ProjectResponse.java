package com.lovable.lovable_ai.dto.project;

import com.lovable.lovable_ai.dto.auth.UserProfileResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.UUID;

@Schema(description = "Full details of a project, including its owner")
public record ProjectResponse(

        @Schema(
                description = "Unique identifier of the project",
                example = "b1c2d3e4-f5a6-4b7c-8d9e-0123456789ab",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        UUID id,

        @Schema(
                description = "Name of the project",
                example = "My Portfolio Website",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String name,

        @Schema(
                description = "Timestamp (UTC, ISO-8601) of when the project was created",
                example = "2026-11-25T10:15:30Z",
                type = "string",
                format = "date-time",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Instant createdAt,

        @Schema(
                description = "Timestamp (UTC, ISO-8601) of when the project was last updated",
                example = "2026-11-25T12:40:00Z",
                type = "string",
                format = "date-time",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Instant updatedAt,

        @Schema(
                description = "Profile of the user who owns the project",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        UserProfileResponse owner
) {
}