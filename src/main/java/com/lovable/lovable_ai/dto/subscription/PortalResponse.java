package com.lovable.lovable_ai.dto.subscription;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response returned after a billing portal session has been created")
public record PortalResponse(

        @Schema(
                description = "URL of the hosted billing portal. Redirect the user to this URL so they can manage their subscription, payment methods, and invoices",
                example = "https://billing.stripe.com/p/session/test_a1b2c3d4e5",
                format = "uri",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String portalUrl
) {
}