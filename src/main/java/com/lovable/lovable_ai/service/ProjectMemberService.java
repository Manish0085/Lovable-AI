package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.member.InviteMemberRequest;
import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.dto.member.UpdateMemberRoleRequest;

import java.util.List;
import java.util.UUID;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(UUID projectId, UUID userId);

    MemberResponse inviteMember(UUID projectId, InviteMemberRequest request, UUID userId);

    MemberResponse updateMemberRole(UUID projectId, UUID memberId, UpdateMemberRoleRequest request, UUID userId);

    void removeProjectMember(UUID projectId, UUID userId);
}

