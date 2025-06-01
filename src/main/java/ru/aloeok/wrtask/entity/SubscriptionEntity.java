package ru.aloeok.wrtask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
@Entity(name = "subscriptions")
@Table(name = "subscriptions")
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Setter
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "subscriptions", fetch = FetchType.LAZY)
    private Set<UserEntity> users = new HashSet<>();
}
