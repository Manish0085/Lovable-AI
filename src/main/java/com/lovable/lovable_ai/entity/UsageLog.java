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
public class UsageLog {

    UUID id;
    User user;
    Project project;
    String action;
    Integer tokensUSed;
    Integer durationMs;
    String metaData; // JSON of a {model_used, prompt_used}
    Instant createdAt;
}
