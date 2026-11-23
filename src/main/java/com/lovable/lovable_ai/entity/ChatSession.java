package com.lovable.lovable_ai.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ChatSession {

    Project project;
    User user;
    String title;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;
}
