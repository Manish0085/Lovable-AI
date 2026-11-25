package com.lovable.lovable_ai.entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class ProjectMemberId {

    UUID projectId;
    UUID userId;


}
