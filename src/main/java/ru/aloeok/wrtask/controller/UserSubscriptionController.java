package ru.aloeok.wrtask.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aloeok.wrtask.dto.CreateSubscriptionDto;
import ru.aloeok.wrtask.dto.CreateUserDto;
import ru.aloeok.wrtask.dto.SubscriptionDto;
import ru.aloeok.wrtask.dto.SubscriptionListDto;
import ru.aloeok.wrtask.dto.UserDto;
import ru.aloeok.wrtask.dto.UserListDto;
import ru.aloeok.wrtask.model.User;
import ru.aloeok.wrtask.service.UserSubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserSubscriptionController {
    private final UserSubscriptionService userSubscriptionService;

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        Long id = userSubscriptionService.createUser(createUserDto.getUsername());
        return ResponseEntity.ok(UserDto.builder()
                .id(id)
                .username(createUserDto.getUsername())
                .build());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        User user = userSubscriptionService.getUser(id);
        return ResponseEntity.ok(UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build());
    }

    // TODO: remove
    @GetMapping("/users")
    public ResponseEntity<UserListDto> getAllUsers() {
        List<UserDto> users = userSubscriptionService.getAllUsers().stream()
                .map(u -> UserDto.builder()
                        .id(u.getId())
                        .username(u.getUsername())
                        .build())
                .toList();
        return ResponseEntity.ok(UserListDto.builder()
                .users(users)
                .build());
    }

    // TODO: remove
    @GetMapping("/subscriptions")
    public ResponseEntity<SubscriptionListDto> getAllSubscriptions() {
        List<SubscriptionDto> subscriptions = userSubscriptionService.getAllSubscriptions().stream()
                .map(s -> SubscriptionDto.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .build())
                .toList();
        return ResponseEntity.ok(SubscriptionListDto.builder()
                .subscriptions(subscriptions)
                .build());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable("id") Long id,
            @RequestBody @Valid CreateUserDto createUserDto
    ) {
        userSubscriptionService.updateUser(id, createUserDto.getUsername());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userSubscriptionService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/subscriptions")
    public ResponseEntity<SubscriptionDto> createSubscription(
            @RequestBody @Valid CreateSubscriptionDto createSubscriptionDto
    ) {
        Long id = userSubscriptionService.createSubscription(createSubscriptionDto.getName());
        return ResponseEntity.ok(SubscriptionDto.builder()
                .id(id)
                .name(createSubscriptionDto.getName())
                .build());
    }

    @DeleteMapping("/subscriptions/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable("id") Long id) {
        userSubscriptionService.deleteSubscription(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/users/{id}/subscriptions/{sub_id}")
    public ResponseEntity<Void> addUserSubscription(
            @PathVariable("id") Long userId,
            @PathVariable("sub_id") Long subscriptionId
    ) {
        userSubscriptionService.addUserSubscription(userId, subscriptionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/{id}/subscriptions")
    public ResponseEntity<SubscriptionListDto> getUserSubscriptions(@PathVariable("id") Long userId) {
        List<SubscriptionDto> list = userSubscriptionService.getUserSubscriptions(userId).stream()
                .map(s -> SubscriptionDto.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .build())
                .toList();
        return ResponseEntity.ok(SubscriptionListDto.builder()
                .subscriptions(list)
                .build());
    }

    @DeleteMapping("/users/{id}/subscriptions/{sub_id}")
    public ResponseEntity<Void> deleteUserSubscription(
            @PathVariable("id") Long userId,
            @PathVariable("sub_id") Long subscriptionId
    ) {
        userSubscriptionService.deleteUserSubscription(userId, subscriptionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/subscriptions/top")
    public ResponseEntity<SubscriptionListDto> getTop3Subscriptions() {
        List<SubscriptionDto> list = userSubscriptionService.getTop3Subscriptions().stream()
                .map(s -> SubscriptionDto.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .build())
                .toList();
        return ResponseEntity.ok(SubscriptionListDto.builder()
                .subscriptions(list)
                .build());
    }
}
