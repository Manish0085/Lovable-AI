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
public class Project {

    UUID id;
    String name;
    User owner;
    Boolean isActive = false;

    Instant createAt;
    Instant updatedAt;
    Instant deletedAt;  // Soft Delete
}
