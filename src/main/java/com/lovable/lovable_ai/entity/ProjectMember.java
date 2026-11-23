package com.lovable.lovable_ai.entity;

import com.lovable.lovable_ai.constants.ProjectRole;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProjectMember {

    ProjectMemberId Id;

    Project project;
    User user;

    ProjectRole projectRole;
    String invitedBy;
    Instant acceptedAt;

}
