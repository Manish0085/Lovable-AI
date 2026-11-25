package com.lovable.lovable_ai.dto.subscription;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "The user's resource usage for the current day, alongside the limits that apply to their plan")
public record UsageTodayResponse(

        @Schema(
                description = "Number of AI tokens consumed so far today",
                example = "42500",
                minimum = "0",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Integer tokenUsed,

        @Schema(
                description = "Maximum number of AI tokens allowed per day under the current plan. Null when the plan has unlimited AI usage",
                example = "100000",
                minimum = "0",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                nullable = true
        )
        Integer tokenLimit,

        @Schema(
                description = "Number of preview environments currently running for the user",
                example = "1",
                minimum = "0",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Integer previewsRunning,

        @Schema(
                description = "Maximum number of preview environments the user can run at the same time under the current plan",
                example = "3",
                minimum = "0",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Integer previewsLimit
) {
}