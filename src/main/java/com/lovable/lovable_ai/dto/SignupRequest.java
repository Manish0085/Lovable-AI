package com.lovable.lovable_ai.dto;

public record SignupRequest(
        String name,
        String email,
        String password
) {
}
