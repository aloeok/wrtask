package ru.aloeok.wrtask.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aloeok.wrtask.entity.SubscriptionEntity;
import ru.aloeok.wrtask.entity.UserEntity;
import ru.aloeok.wrtask.model.Subscription;
import ru.aloeok.wrtask.model.User;
import ru.aloeok.wrtask.repository.SubscriptionRepository;
import ru.aloeok.wrtask.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserSubscriptionService {
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Transactional
    public @NotNull Long createUser(@NotNull String username) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userRepository.save(userEntity);
        return userEntity.getId();
    }

    @Transactional(readOnly = true)
    public @NotNull User getUser(@NotNull Long id) {
        return userRepository.findById(id)
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getUsername()
                ))
                .orElseThrow(() -> new EntityNotFoundException(
                        "User not found"
                ));
    }

    // TODO: remove
    @Transactional(readOnly = true)
    public @NotNull List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getUsername()
                ))
                .toList();
    }

    // TODO: remove
    @Transactional(readOnly = true)
    public @NotNull List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll().stream()
                .map(subscriptionEntity -> new Subscription(
                        subscriptionEntity.getId(),
                        subscriptionEntity.getName()
                ))
                .toList();
    }

    @Transactional
    public void updateUser(@NotNull Long id, @NotNull String username) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        userEntity.setUsername(username);
    }

    @Transactional
    public void deleteUser(@NotNull Long id) {
        userRepository.deleteById(id);
    }


    @Transactional
    public @NotNull Long createSubscription(@NotNull String name) {
        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setName(name);
        subscriptionRepository.save(subscriptionEntity);
        return subscriptionEntity.getId();
    }

    @Transactional
    public void deleteSubscription(@NotNull Long id) {
        subscriptionRepository.deleteById(id);
    }


    @Transactional
    public void addUserSubscription(@NotNull Long userId, @NotNull Long subscriptionId) {
        UserEntity userEntity = userRepository.getReferenceById(userId);
        SubscriptionEntity subscriptionEntity = subscriptionRepository.getReferenceById(subscriptionId);
        userEntity.getSubscriptions().add(subscriptionEntity);
    }

    @Transactional(readOnly = true)
    public @NotNull List<Subscription> getUserSubscriptions(@NotNull Long userId) {
        return subscriptionRepository.findByUsersId(userId).stream()
                .map(subscriptionEntity -> new Subscription(
                        subscriptionEntity.getId(),
                        subscriptionEntity.getName()
                ))
                .toList();
    }

    @Transactional
    public void deleteUserSubscription(@NotNull Long userId, @NotNull Long subscriptionId) {
        UserEntity userEntity = userRepository.getReferenceById(userId);
        SubscriptionEntity subscriptionEntity = subscriptionRepository.getReferenceById(subscriptionId);
        userEntity.getSubscriptions().remove(subscriptionEntity);
    }

    @Transactional(readOnly = true)
    public @NotNull List<Subscription> getTop3Subscriptions() {
        return subscriptionRepository.findSortedByUserCount(Pageable.ofSize(3)).stream()
                .map(subscriptionEntity -> new Subscription(
                        subscriptionEntity.getId(),
                        subscriptionEntity.getName()
                ))
                .toList();
    }
}
