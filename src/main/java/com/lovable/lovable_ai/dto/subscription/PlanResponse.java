package com.lovable.lovable_ai.dto.subscription;

import com.lovable.lovable_ai.constants.SubscriptionStatus;
import com.lovable.lovable_ai.entity.Plan;
import com.lovable.lovable_ai.entity.User;

import java.time.Instant;
import java.util.UUID;

public record PlanResponse(
        UUID id,
        String name,
        Integer maxProjects,
        Integer maxTokenPerDay,
        Boolean unlimitedAi,
        String price
) {
}
