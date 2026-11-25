package com.lovable.lovable_ai.security;

import com.lovable.lovable_ai.constants.ProjectPermission;
import com.lovable.lovable_ai.constants.ProjectRole;
import com.lovable.lovable_ai.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {

    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;
    public boolean canViewProject(UUID projectId) {
        return hasPermission(projectId, ProjectPermission.VIEW);
    }

    public boolean canEditProject(UUID projectId) {
        return hasPermission(projectId, ProjectPermission.EDIT);
    }

    public boolean canDeleteProject(UUID projectId) {
        return hasPermission(projectId, ProjectPermission.DELETE);
    }

    public boolean canViewMembers(UUID projectId) {
        return hasPermission(projectId, ProjectPermission.VIEW_MEMBERS);
    }

    public boolean canManageMembers(UUID projectId) {
        return hasPermission(projectId, ProjectPermission.MANAGE_MEMBERS);
    }




    private boolean hasPermission(UUID projectId, ProjectPermission permission) {
        UUID userId = authUtil.getCurrentUserId();
        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId, userId)
                .map(role -> role.getPermissions().contains(permission))
                .orElse(false);
    }

}
