package com.lovable.lovable_ai.entity;


import com.lovable.lovable_ai.constants.MessageRole;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ChatMessage {

    UUID id;
    String chatSession;
    String content;

    MessageRole role;
    String toolCalls; // JSON Array of tools called
    Integer tokensUsed;


    Instant createdAt;

}
