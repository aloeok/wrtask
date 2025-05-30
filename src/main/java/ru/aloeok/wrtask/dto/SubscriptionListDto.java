package ru.aloeok.wrtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Builder
@Jacksonized
public class SubscriptionListDto {
    @JsonProperty("subscriptions")
    private final List<SubscriptionDto> subscriptions;
}
