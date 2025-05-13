package ru.makhorin.service;

import ru.makhorin.dto.SubscriptionDto;
import ru.makhorin.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto get(Long id);
    UserDto update(Long id, UserDto userDto);
    void delete(Long id);

    SubscriptionDto addSubscription(Long userId, SubscriptionDto subscriptionDto);
    List<SubscriptionDto> getSubscriptions(Long userId);
    void deleteSubscription(Long userId, Long subId);
    List<String> getTopSubscriptions();
}
