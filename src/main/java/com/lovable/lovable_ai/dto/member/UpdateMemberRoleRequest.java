package com.lovable.lovable_ai.dto.member;

import com.lovable.lovable_ai.constants.ProjectRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request payload for changing an existing member's role within a project")
public record UpdateMemberRoleRequest(

        @Schema(
                description = "The new role to assign to the member",
                example = "VIEWER",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull(message = "Role is required")
        ProjectRole role
) {
}