package com.lovable.lovable_ai.service;

import com.lovable.lovable_ai.dto.subscription.*;

import java.util.List;
import java.util.UUID;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();

    SubscriptionResponse getMySubscription(UUID userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, UUID userId);

    PortalResponse openCustomerPortal(UUID userId);
}
