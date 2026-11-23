package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.auth.UserProfileResponse;
import com.lovable.lovable_ai.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserProfileResponse getProfile(UUID userId) {
        return null;
    }
}
