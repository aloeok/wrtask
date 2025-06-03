package ru.aloeok.wrtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

// TODO: remove
@Getter
@Builder
@Jacksonized
public class UserListDto {
    @org.jetbrains.annotations.NotNull
    @JsonProperty("users")
    private final List<UserDto> users;
}
