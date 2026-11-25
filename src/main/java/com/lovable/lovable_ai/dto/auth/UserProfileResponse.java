package com.lovable.lovable_ai.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Public profile information of a user")
public record UserProfileResponse(

        @Schema(
                description = "Unique identifier of the user",
                example = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        UUID id,

        @Schema(
                description = "Email address of the user",
                example = "jane.doe@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String email,

        @Schema(
                description = "Display name of the user",
                example = "Jane Doe",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String name,

        @Schema(
                description = "URL of the user's avatar image. Null if the user has not set one",
                example = "https://cdn.example.com/avatars/jane.png",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                nullable = true
        )
        String avatarUrl
) {
}