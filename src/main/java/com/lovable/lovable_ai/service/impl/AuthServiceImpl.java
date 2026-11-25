package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.auth.AuthResponse;
import com.lovable.lovable_ai.dto.auth.LoginRequest;
import com.lovable.lovable_ai.dto.auth.SignupRequest;
import com.lovable.lovable_ai.entity.User;
import com.lovable.lovable_ai.exception.BadRequestException;
import com.lovable.lovable_ai.mapper.UserMapper;
import com.lovable.lovable_ai.repository.UserRepository;
import com.lovable.lovable_ai.security.AuthUtil;
import com.lovable.lovable_ai.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;
    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username())
                .ifPresent(user -> {
                    throw new BadRequestException("User with username " + request.username() + " already exists");
                });


        User user = userMapper.toEntityFromSignupRequest(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);
        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }
}
