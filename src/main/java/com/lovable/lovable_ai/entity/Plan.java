package com.lovable.lovable_ai.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Plan {

    UUID id;
    String name;
    String stripePriceId;
    Integer maxProjects;
    Integer maxTokenPerDay;
    Integer maxPreviews;
    Boolean unlimitedAi;
    Boolean active;

}
