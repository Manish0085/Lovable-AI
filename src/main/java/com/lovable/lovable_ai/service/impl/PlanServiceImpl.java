package com.lovable.lovable_ai.service.impl;

import com.lovable.lovable_ai.dto.subscription.*;
import com.lovable.lovable_ai.entity.User;
import com.lovable.lovable_ai.repository.ProjectRepository;
import com.lovable.lovable_ai.repository.UserRepository;
import com.lovable.lovable_ai.service.PlanService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PlanServiceImpl implements PlanService {

    ProjectRepository projectRepository;
    UserRepository userRepository;

    @Override
    public List<PlanResponse> getAllActivePlans() {

        return null;
    }

    @Override
    public SubscriptionResponse getMySubscription(UUID userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, UUID userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(UUID userId) {
        return null;
    }
}
