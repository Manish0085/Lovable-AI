package com.lovable.lovable_ai.security;

import com.lovable.lovable_ai.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Component
public class AuthUtil {

    @Value("${jwt.secret-key}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private String jwtExpiration;

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }
    public String generateAccessToken(User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId", user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + Integer.parseInt(jwtExpiration)))
                .signWith(getSecretKey())
                .compact();
    }

    public JwtUserPrinciple verifyAccessToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        UUID userId = UUID.fromString(claims.get("userId", String.class));
        String username = claims.getSubject();
        return new JwtUserPrinciple(userId, username, new ArrayList<>());
    }

    public UUID getCurrentUserId() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof JwtUserPrinciple)) {
            throw new AuthenticationCredentialsNotFoundException("Jwt is not found");
        }

        return ((JwtUserPrinciple) authentication.getPrincipal()).userId();

    }
}
