package com.lovable.lovable_ai.dto.subscription;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "A subscription plan that users can purchase, including its price and usage limits")
public record PlanResponse(

        @Schema(
                description = "Unique identifier of the plan. Pass this as planId when starting a checkout",
                example = "7c9e6679-7425-40de-944b-e07fc1f90ae7",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        UUID id,

        @Schema(
                description = "Display name of the plan",
                example = "Pro",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String name,

        @Schema(
                description = "Maximum number of projects a subscriber can create under this plan",
                example = "10",
                minimum = "0",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Integer maxProjects,

        @Schema(
                description = "Maximum number of AI tokens a subscriber can consume per day. Null or ignored when unlimitedAi is true",
                example = "100000",
                minimum = "0",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                nullable = true
        )
        Integer maxTokenPerDay,

        @Schema(
                description = "Whether the plan allows unlimited AI usage. When true, maxTokenPerDay does not apply",
                example = "false",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Boolean unlimitedAi,

        @Schema(
                description = "Human-readable price of the plan, including currency and billing period",
                example = "$19.99/month",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String price
) {
}