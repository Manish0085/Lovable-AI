package com.lovable.lovable_ai.mapper;

import com.lovable.lovable_ai.constants.ProjectRole;
import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.entity.ProjectMember;
import com.lovable.lovable_ai.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(source = "id", target = "userId")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
