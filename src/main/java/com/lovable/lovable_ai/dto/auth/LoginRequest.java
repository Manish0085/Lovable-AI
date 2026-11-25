package com.lovable.lovable_ai.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Credentials used to authenticate an existing user")
public record LoginRequest(

        @Schema(
                description = "Email address or username of the account",
                example = "jane.doe@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED,
                maxLength = 254
        )
        @NotBlank(message = "Email or username is required")
        @Email(message = "Email or username must be a valid")
        @Size(max = 254, message = "Email or username must not exceed 254 characters")
        String username,

        @Schema(
                description = "Account password",
                example = "S3cureP@ssw0rd!",
                requiredMode = Schema.RequiredMode.REQUIRED,
                format = "password",
                accessMode = Schema.AccessMode.WRITE_ONLY
        )
        @NotBlank(message = "Password is required")
        @Size(max = 128, message = "Password must not exceed 128 characters")
        String password
) {
}