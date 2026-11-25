package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.auth.AuthResponse;
import com.lovable.lovable_ai.dto.auth.LoginRequest;
import com.lovable.lovable_ai.dto.auth.SignupRequest;
import com.lovable.lovable_ai.entity.User;
import com.lovable.lovable_ai.exception.BadRequestException;
import com.lovable.lovable_ai.mapper.UserMapper;
import com.lovable.lovable_ai.repository.UserRepository;
import com.lovable.lovable_ai.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class AuthServiceImpl implements AuthService {


    UserRepository userRepository;
    UserMapper userMapper;
    BCryptPasswordEncoder passwordEncoder;
    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username())
                .ifPresent(user -> {
                    throw new BadRequestException("User with username " + request.username() + " already exists");
                });


        User user = userMapper.toEntityFromSignupRequest(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        return new AuthResponse("dummyToken", userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
