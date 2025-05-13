package ru.makhorin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhorin.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
