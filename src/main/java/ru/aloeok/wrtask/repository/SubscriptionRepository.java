package ru.aloeok.wrtask.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.aloeok.wrtask.entity.SubscriptionEntity;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    List<SubscriptionEntity> findByUsersId(Long userId);

    @Query("""
    select s from subscriptions s
    left join s.users u
    group by s
    order by count(u) desc
    """)
    List<SubscriptionEntity> findSortedByUserCount(Pageable pageable);
}
