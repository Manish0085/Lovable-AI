package com.lovable.lovable_ai.dto.subscription;

public record PlanLimitResponse(
        String planName,
        Integer maxTokenPerDay,
        Integer maxProjects,
        boolean unlimitedAi
) {
}
