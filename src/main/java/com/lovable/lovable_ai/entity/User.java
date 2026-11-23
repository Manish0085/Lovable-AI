package com.lovable.lovable_ai.entity;


import jdk.jfr.Experimental;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    UUID id;

    String email;

    String passwordHash;

    String name;
    String avatarUrl;

    Instant createAt;
    Instant updatedAt;
    Instant deletedAt;  // Soft Delete
}
