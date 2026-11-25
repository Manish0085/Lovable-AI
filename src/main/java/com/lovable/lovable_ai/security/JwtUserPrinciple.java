package com.lovable.lovable_ai.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.UUID;

public record JwtUserPrinciple(
        UUID userId,
        String username,
        List<GrantedAuthority> authorities
) {
}
