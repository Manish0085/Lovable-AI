package com.lovable.lovable_ai.dto.member;

import com.lovable.lovable_ai.constants.ProjectRole;

import java.time.Instant;
import java.util.UUID;

public record MemberResponse(
        UUID id,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
