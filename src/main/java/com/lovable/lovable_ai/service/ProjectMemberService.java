package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.member.InviteMemberRequest;
import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.dto.member.updateMemberRoleRequest;
import com.lovable.lovable_ai.entity.ProjectMember;

import java.util.List;
import java.util.UUID;

public interface ProjectMemberService {
    List<ProjectMember> getProjectMembers(UUID projectId, UUID userId);

    MemberResponse inviteMember(UUID projectId, InviteMemberRequest request, UUID userId);

    MemberResponse updateMemberRole(UUID projectId, updateMemberRoleRequest request, UUID userId);

    void deleteProjectMember(UUID projectId, UUID userId);
}

