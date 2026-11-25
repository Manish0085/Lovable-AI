package com.lovable.lovable_ai.dto.subscription;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response returned after a checkout session has been created")
public record CheckoutResponse(

        @Schema(
                description = "URL of the hosted checkout page. Redirect the user to this URL to complete the payment",
                example = "https://checkout.stripe.com/c/pay/cs_test_a1b2c3d4e5",
                format = "uri",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String checkoutUrl
) {
}