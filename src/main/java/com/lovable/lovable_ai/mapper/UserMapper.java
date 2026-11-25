package com.lovable.lovable_ai.mapper;

import com.lovable.lovable_ai.dto.auth.AuthResponse;
import com.lovable.lovable_ai.dto.auth.SignupRequest;
import com.lovable.lovable_ai.dto.auth.UserProfileResponse;
import com.lovable.lovable_ai.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntityFromSignupRequest(SignupRequest request);

    UserProfileResponse toUserProfileResponse(User user);
}
