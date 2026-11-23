package com.lovable.lovable_ai.controller;

import com.lovable.lovable_ai.dto.AuthResponse;
import com.lovable.lovable_ai.dto.LoginRequest;
import com.lovable.lovable_ai.dto.SignupRequest;
import com.lovable.lovable_ai.dto.UserProfileResponse;
import com.lovable.lovable_ai.service.AuthService;
import com.lovable.lovable_ai.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(@RequestBody LoginRequest request) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
