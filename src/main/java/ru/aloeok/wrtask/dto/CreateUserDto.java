package ru.aloeok.wrtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateUserDto {
    @jakarta.validation.constraints.NotNull
    @JsonProperty("username")
    private final String username;
}
