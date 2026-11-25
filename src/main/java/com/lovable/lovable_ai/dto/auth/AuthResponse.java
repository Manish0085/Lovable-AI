package com.lovable.lovable_ai.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response returned after a successful authentication (login or signup)")
public record AuthResponse(

        @Schema(
                description = "JWT access token. Send it in the Authorization header as 'Bearer <token>' on subsequent requests",
                example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjMifQ.signature",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String token,

        @Schema(
                description = "Profile of the authenticated user",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        UserProfileResponse user
) {
}