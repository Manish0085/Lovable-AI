package com.lovable.lovable_ai.dto.auth;

public record SignupRequest(
        String name,
        String email,
        String password
) {
}
