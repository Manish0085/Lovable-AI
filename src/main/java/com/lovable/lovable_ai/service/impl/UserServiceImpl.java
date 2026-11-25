package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.auth.UserProfileResponse;
import com.lovable.lovable_ai.exception.ResourceNotFoundException;
import com.lovable.lovable_ai.repository.UserRepository;
import com.lovable.lovable_ai.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService, UserDetailsService {

    UserRepository userRepository;
    @Override
    public UserProfileResponse getProfile(UUID userId) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("USER", "User with username " + username + " not found"));
    }
}
