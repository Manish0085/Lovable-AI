package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.subscription.PlanLimitResponse;
import com.lovable.lovable_ai.dto.subscription.UsageTodayResponse;

import java.util.UUID;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(UUID userId);

    PlanLimitResponse getCurrentSubscriptionLimitOfUser(UUID userId);
}
