package com.lovable.lovable_ai.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProjectFile {

    UUID id;
    Project project;
    String path;
    String storageKey;
    Instant createdAt;
    Instant updatedAt;
    User createdBy;
    User  updatedBy;
}
