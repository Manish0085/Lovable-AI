package com.lovable.lovable_ai.entity;

import com.lovable.lovable_ai.constants.PreviewStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Preview {

    UUID id;

    Project project;
    String namespace;
    String podName;
    String previewUrl;
    PreviewStatus status;
    Instant startedAt;
    Instant createdAt;
    Instant terminatedAt;
}
