package com.lovable.lovable_ai.controller;

import com.lovable.lovable_ai.dto.subscription.PlanLimitResponse;
import com.lovable.lovable_ai.dto.subscription.UsageTodayResponse;
import com.lovable.lovable_ai.service.UsageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UsageController {

    UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getTodayUsage() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));

    }

    @GetMapping("/limit")
    public ResponseEntity<PlanLimitResponse> getPlanLimits() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitOfUser (userId));

    }
}
