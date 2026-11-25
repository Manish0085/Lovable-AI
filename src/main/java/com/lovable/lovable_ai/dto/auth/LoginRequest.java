package com.lovable.lovable_ai.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Credentials used to authenticate an existing user")
public record LoginRequest(

        @Schema(
                description = "Email address of the account",
                example = "jane.doe@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED,
                maxLength = 254
        )
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be a valid email address")
        @Size(max = 254, message = "Email must not exceed 254 characters")
        String email,

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