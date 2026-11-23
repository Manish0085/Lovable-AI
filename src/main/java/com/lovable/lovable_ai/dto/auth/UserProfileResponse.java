package com.lovable.lovable_ai.dto.auth;

import java.util.UUID;

public record UserProfileResponse(
        UUID id,
        String email,
        String name,
        String avatarUrl
) {
}
