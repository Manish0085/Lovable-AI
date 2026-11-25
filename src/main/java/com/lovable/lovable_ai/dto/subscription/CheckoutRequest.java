package com.lovable.lovable_ai.dto.subscription;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Schema(description = "Request payload for starting a checkout session for a subscription plan")
public record CheckoutRequest(

        @Schema(
                description = "Unique identifier of the subscription plan the user wants to purchase",
                example = "7c9e6679-7425-40de-944b-e07fc1f90ae7",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull(message = "Plan ID is required")
        UUID planId
) {
}