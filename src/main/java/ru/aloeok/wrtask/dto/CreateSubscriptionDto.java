package ru.aloeok.wrtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateSubscriptionDto {
    @jakarta.validation.constraints.NotNull
    @JsonProperty("name")
    private final String name;
}
