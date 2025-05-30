package ru.aloeok.wrtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UserDto {
    @org.jetbrains.annotations.NotNull
    @JsonProperty("id")
    private final Long id;

    @org.jetbrains.annotations.NotNull
    @JsonProperty("username")
    private final String username;
}
