package com.lovable.lovable_ai.dto.project;

import com.lovable.lovable_ai.dto.auth.UserProfileResponse;

import java.time.Instant;
import java.util.UUID;

public record ProjectResponse(
        UUID id,
        String name,
        Instant createdAt,
        Instant updated,
        UserProfileResponse owner
) {
}
