package com.lovable.lovable_ai.controller;

import com.lovable.lovable_ai.dto.subscription.*;
import com.lovable.lovable_ai.service.PlanService;
import com.lovable.lovable_ai.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BillingController {

    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {
        return ResponseEntity
                .ok(planService.getAllActivePlans());
    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity
                .ok(planService.getMySubscription(userId));
    }

    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(@RequestBody CheckoutRequest request) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity
                .ok(planService.createCheckoutSessionUrl(request, userId));
    }

    @PostMapping("/api/stripe/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal(@RequestBody CheckoutRequest request) {
        UUID userId = UUID.randomUUID();
        return ResponseEntity
                .ok(planService.openCustomerPortal(userId));
    }
}
