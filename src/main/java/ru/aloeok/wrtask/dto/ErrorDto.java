package ru.aloeok.wrtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class ErrorDto {
    @org.jetbrains.annotations.NotNull
    @JsonProperty("details")
    private String details;
}
