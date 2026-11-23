package com.lovable.lovable_ai.dto.subscription;

import java.util.UUID;

public record CheckoutRequest(
        UUID planId
) {
}
