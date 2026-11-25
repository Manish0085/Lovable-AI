package com.lovable.lovable_ai.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.lovable.lovable_ai.constants.ProjectPermission.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    EDITOR(VIEW, EDIT, DELETE, VIEW_MEMBERS),
    VIEWER(Set.of(VIEW, VIEW_MEMBERS)),
    OWNER(EDIT, VIEW, DELETE, MANAGE_MEMBERS, VIEW_MEMBERS);

    private final Set<ProjectPermission> permissions;

    ProjectRole(ProjectPermission... permissions) {
        this.permissions = Set.of(permissions);
    }
}
