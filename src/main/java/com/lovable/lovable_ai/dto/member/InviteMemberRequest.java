package com.lovable.lovable_ai.dto.member;

import com.lovable.lovable_ai.constants.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
