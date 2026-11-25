package com.lovable.lovable_ai.dto.member;

import com.lovable.lovable_ai.constants.ProjectRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Request payload for inviting a user to a project")
public record InviteMemberRequest(

        @Schema(
                description = "Email address or username of the user to invite",
                example = "jane.doe@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED,
                maxLength = 254
        )
        @NotBlank(message = "Email or username is required")
        @Email(message = "Email or username must be a valid email address")
        @Size(max = 254, message = "Email must not exceed 254 characters")
        String username,

        @Schema(
                description = "Role to assign to the invited member within the project",
                example = "EDITOR",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull(message = "Role is required")
        ProjectRole role
) {
}