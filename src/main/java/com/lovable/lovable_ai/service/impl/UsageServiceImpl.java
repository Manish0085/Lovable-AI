package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.subscription.PlanLimitResponse;
import com.lovable.lovable_ai.dto.subscription.UsageTodayResponse;
import com.lovable.lovable_ai.service.UsageService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(UUID userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitOfUser(UUID userId) {
        return null;
    }
}
