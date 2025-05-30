package ru.aloeok.wrtask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class Subscription {
    @NotNull
    private final Long id;

    @NotNull
    private final String name;
}
