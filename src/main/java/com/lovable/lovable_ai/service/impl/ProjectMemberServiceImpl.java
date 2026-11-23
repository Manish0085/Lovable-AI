package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.member.InviteMemberRequest;
import com.lovable.lovable_ai.dto.member.MemberResponse;
import com.lovable.lovable_ai.dto.member.UpdateMemberRoleRequest;
import com.lovable.lovable_ai.service.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponse> getProjectMembers(UUID projectId, UUID userId) {
        return null;
    }

    @Override
    public MemberResponse inviteMember(UUID projectId, InviteMemberRequest request, UUID userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(UUID projectId, UpdateMemberRoleRequest request, UUID userId) {
        return null;
    }

    @Override
    public void deleteProjectMember(UUID projectId, UUID userId) {

    }
}
