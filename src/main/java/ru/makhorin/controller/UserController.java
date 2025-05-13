package ru.makhorin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.makhorin.dto.SubscriptionDto;
import ru.makhorin.dto.UserDto;

import java.util.List;

/**
 * Интерфейс для управления пользователем
 */
@RequestMapping("/users")
public interface UserController {

    /**
     * Метод для сохранения нового пользователя
     *
     * @param userDto пользователь {@link UserDto}
     */
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto);

    /**
     * Метод для получения информации о пользователе по id
     *
     * @param id пользователя
     * @return информацию о счете {@link UserDto}
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id);

    /**
     * Метод для обновления пользователя по id
     *
     * @param id пользователя
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto);

    /**
     * Метод для удаления пользователя по id
     *
     * @param id пользователя
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id);

    /**
     * Метод для сохранения подписки пользователя
     *
     * @param id пользователя {@link SubscriptionDto}
     */
    @PostMapping("/{id}/subscriptions")
    public ResponseEntity<SubscriptionDto> addSubscription(@PathVariable Long id, @RequestBody SubscriptionDto dto);

    /**
     * Метод для получения списка всех подписок пользователя
     *
     * @return список всех подписок {@link SubscriptionDto}
     */
    @GetMapping("/{id}/subscriptions")
    public ResponseEntity<List<SubscriptionDto>> getSubscriptions(@PathVariable Long id);

    /**
     * Метод для удаления подписки пользователя по id
     *
     * @param subId подписки
     */
    @DeleteMapping("/{id}/subscriptions/{subId}")
    public ResponseEntity<Void> deleteSub(@PathVariable Long id, @PathVariable Long subId);

    /**
     * Метод для получения списка топ 3 подписок пользователей
     */
    @GetMapping("/subscriptions/top")
    public ResponseEntity<List<String>> getTop3();
}
