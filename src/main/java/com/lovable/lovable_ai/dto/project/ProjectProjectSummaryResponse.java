package com.lovable.lovable_ai.dto.project;

import java.time.Instant;
import java.util.UUID;

public record ProjectProjectSummaryResponse (
        UUID id,
        String name,
        Instant createdAt,
        Instant updated
){
}
