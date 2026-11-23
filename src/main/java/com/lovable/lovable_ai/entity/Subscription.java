package com.lovable.lovable_ai.entity;

import com.lovable.lovable_ai.constants.SubscriptionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Subscription {

    UUID id;
    User user;
    Plan plan;

    SubscriptionStatus status;
    String stripeCustomerID;
    String stripeSubscriptionID;
    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    Instant cancelAtPeriodEnd;
    Instant createdAt;
    Instant updatedAt;
}
