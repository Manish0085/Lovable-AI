package com.lovable.lovable_ai.dto.subscription;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Usage limits that apply to the user's current subscription plan")
public record PlanLimitResponse(

        @Schema(
                description = "Name of the subscription plan these limits belong to",
                example = "Pro",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String planName,

        @Schema(
                description = "Maximum number of AI tokens the user can consume per day. Null or ignored when unlimitedAi is true",
                example = "100000",
                minimum = "0",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED,
                nullable = true
        )
        Integer maxTokenPerDay,

        @Schema(
                description = "Maximum number of projects the user can create under this plan",
                example = "10",
                minimum = "0",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Integer maxProjects,

        @Schema(
                description = "Whether the plan allows unlimited AI usage. When true, maxTokenPerDay does not apply",
                example = "false",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        boolean unlimitedAi
) {
}