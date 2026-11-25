package com.lovable.lovable_ai.controller;

import com.lovable.lovable_ai.dto.auth.AuthResponse;
import com.lovable.lovable_ai.dto.auth.LoginRequest;
import com.lovable.lovable_ai.dto.auth.SignupRequest;
import com.lovable.lovable_ai.dto.auth.UserProfileResponse;
import com.lovable.lovable_ai.service.AuthService;
import com.lovable.lovable_ai.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Validated
public class AuthController {

    AuthService authService;
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody @Valid SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(@RequestBody @Valid LoginRequest request) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
