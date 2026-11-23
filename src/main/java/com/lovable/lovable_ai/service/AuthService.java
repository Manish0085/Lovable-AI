package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.auth.AuthResponse;
import com.lovable.lovable_ai.dto.auth.LoginRequest;
import com.lovable.lovable_ai.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
