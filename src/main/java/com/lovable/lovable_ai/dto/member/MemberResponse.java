package com.lovable.lovable_ai.dto.member;

import com.lovable.lovable_ai.constants.ProjectRole;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.UUID;

@Schema(description = "A member of a project, including their role and invitation details")
public record MemberResponse(

        @Schema(
                description = "Unique identifier of the member (user)",
                example = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        UUID id,

        @Schema(
                description = "Email address of the member",
                example = "jane.doe@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String email,

        @Schema(
                description = "Display name of the member",
                example = "Jane Doe",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                nullable = true
        )
        String name,

        @Schema(
                description = "URL of the member's avatar image",
                example = "https://cdn.example.com/avatars/jane.png",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                nullable = true
        )
        String avatarUrl,

        @Schema(
                description = "Role the member holds within the project",
                example = "EDITOR",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        ProjectRole projectRole,

        @Schema(
                description = "Timestamp (UTC, ISO-8601) of when the member was invited to the project",
                example = "2026-11-25T10:15:30Z",
                type = "string",
                format = "date-time",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Instant invitedAt
) {
}