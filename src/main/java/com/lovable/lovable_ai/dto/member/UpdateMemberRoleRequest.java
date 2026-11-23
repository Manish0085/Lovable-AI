package com.lovable.lovable_ai.dto.member;

import com.lovable.lovable_ai.constants.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
