package ru.makhorin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.makhorin.dto.SubscriptionDto;
import ru.makhorin.dto.UserDto;
import ru.makhorin.entity.Subscription;
import ru.makhorin.entity.User;
import ru.makhorin.mapper.EntityMapper;
import ru.makhorin.repository.SubscriptionRepository;
import ru.makhorin.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final EntityMapper mapper;

    @Override
    public UserDto create(UserDto userDto) {
        log.info("Пользователь создан: {}", userDto);
        return mapper.toDto(userRepository.save(mapper.toEntity(userDto)));
    }

    @Override
    public UserDto get(Long id) {
        return mapper.toDto(findUser(id));
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        User existing = findUser(id);
        existing.setName(userDto.getName());
        existing.setEmail(userDto.getEmail());
        return mapper.toDto(userRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(findUser(id));
    }

    @Override
    public SubscriptionDto addSubscription(Long userId, SubscriptionDto subDto) {
        User user = findUser(userId);
        Subscription sub = mapper.toEntity(subDto, user);
        return mapper.toDto(subscriptionRepository.save(sub));
    }

    @Override
    public List<SubscriptionDto> getSubscriptions(Long userId) {
        return subscriptionRepository.findByUserId(userId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSubscription(Long userId, Long subscriptionId) {
        Subscription sub = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Подписка не найдена по указанному пользователю"));
        if (!sub.getUser().getId().equals(userId)) {
            throw new RuntimeException("Подписка не принадлежит указанному пользователю");
        }
        subscriptionRepository.delete(sub);
    }

    @Override
    public List<String> getTopSubscriptions() {
        return subscriptionRepository.findTop3Subscriptions(PageRequest.of(0, 3));
    }

    private User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }
}
