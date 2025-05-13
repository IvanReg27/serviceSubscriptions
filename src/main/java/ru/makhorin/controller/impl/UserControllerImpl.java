package ru.makhorin.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.makhorin.controller.UserController;
import ru.makhorin.dto.SubscriptionDto;
import ru.makhorin.dto.UserDto;
import ru.makhorin.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.create(userDto));
    }

    @Override
    public ResponseEntity<UserDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @Override
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.update(id, userDto));
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<SubscriptionDto> addSubscription(@PathVariable Long id, @RequestBody SubscriptionDto dto) {
        return ResponseEntity.ok(userService.addSubscription(id, dto));
    }

    @Override
    public ResponseEntity<List<SubscriptionDto>> getSubscriptions(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getSubscriptions(id));
    }

    @Override
    public ResponseEntity<Void> deleteSub(@PathVariable Long id, @PathVariable Long subId) {
        userService.deleteSubscription(id, subId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<String>> getTop3() {
        return ResponseEntity.ok(userService.getTopSubscriptions());
    }
}
