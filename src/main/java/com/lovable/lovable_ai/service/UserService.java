package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.auth.UserProfileResponse;

import java.util.UUID;

public interface UserService {
    UserProfileResponse getProfile(UUID userId);
}
