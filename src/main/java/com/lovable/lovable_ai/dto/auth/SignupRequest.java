package com.lovable.lovable_ai.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Payload for registering a new user account")
public record SignupRequest(

        @Schema(
                description = "Display name of the user",
                example = "Jane Doe",
                requiredMode = Schema.RequiredMode.REQUIRED,
                minLength = 2,
                maxLength = 100
        )
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @Schema(
                description = "Email address for the new account. Must be unique",
                example = "jane.doe@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED,
                maxLength = 254
        )
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be a valid email address")
        @Size(max = 254, message = "Email must not exceed 254 characters")
        String email,

        @Schema(
                description = "Account password. Must be 8-128 characters and include an uppercase letter, a lowercase letter, a digit, and a special character",
                example = "S3cureP@ssw0rd!",
                requiredMode = Schema.RequiredMode.REQUIRED,
                format = "password",
                accessMode = Schema.AccessMode.WRITE_ONLY,
                minLength = 8,
                maxLength = 128
        )
        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).+$",
                message = "Password must contain an uppercase letter, a lowercase letter, a digit, and a special character"
        )
        String password
) {

    @Override
    public String toString() {
        return "SignupRequest[name=" + name + ", email=" + email + ", password=****]";
    }
}