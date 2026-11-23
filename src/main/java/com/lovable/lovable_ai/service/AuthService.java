package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.AuthResponse;
import com.lovable.lovable_ai.dto.LoginRequest;
import com.lovable.lovable_ai.dto.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
