package ru.makhorin.mapper;

import org.springframework.stereotype.Component;
import ru.makhorin.dto.SubscriptionDto;
import ru.makhorin.dto.UserDto;
import ru.makhorin.entity.Subscription;
import ru.makhorin.entity.User;

import java.time.LocalDateTime;

@Component
public class EntityMapper {

    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public User toEntity(UserDto dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

    public SubscriptionDto toDto(Subscription sub) {
        return new SubscriptionDto(sub.getId(), sub.getServiceName(), sub.getCreatedAt());
    }

    public Subscription toEntity(SubscriptionDto dto, User user) {
        return new Subscription(dto.getId(), dto.getServiceName(), LocalDateTime.now(), user);
    }
}
