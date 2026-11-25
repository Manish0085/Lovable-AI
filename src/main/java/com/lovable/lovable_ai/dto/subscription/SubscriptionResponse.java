package com.lovable.lovable_ai.dto.subscription;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "The user's current subscription, including its plan, status, and usage in the current billing cycle")
public record SubscriptionResponse(

        @Schema(
                description = "The plan the user is currently subscribed to",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        PlanResponse plan,

        @Schema(
                description = "Current status of the subscription",
                example = "ACTIVE",
                allowableValues = {"ACTIVE", "PAST_DUE", "CANCELED", "INCOMPLETE", "TRIALING"},
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String status,

        @Schema(
                description = "Timestamp (UTC, ISO-8601) of when the current billing period ends and the subscription renews or expires",
                example = "2026-12-25T10:15:30Z",
                type = "string",
                format = "date-time",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Instant periodEnd,

        @Schema(
                description = "Number of AI tokens consumed so far in the current billing cycle",
                example = "42500",
                minimum = "0",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Integer tokenUsedThisCycle
) {
}