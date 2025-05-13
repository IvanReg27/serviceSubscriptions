package ru.makhorin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhorin.entity.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findByUserId(Long userId);

    @Query("SELECT s.serviceName FROM Subscription s GROUP BY s.serviceName ORDER BY COUNT(s.serviceName) DESC")
    List<String> findTop3Subscriptions(Pageable pageable);
}
