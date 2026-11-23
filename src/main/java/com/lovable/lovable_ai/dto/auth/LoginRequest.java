package com.lovable.lovable_ai.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
