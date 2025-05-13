package ru.makhorin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.makhorin.dto.SubscriptionDto;
import ru.makhorin.dto.UserDto;
import ru.makhorin.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.create(userDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.update(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/subscriptions")
    public ResponseEntity<SubscriptionDto> addSubscription(@PathVariable Long id, @RequestBody SubscriptionDto dto) {
        return ResponseEntity.ok(userService.addSubscription(id, dto));
    }

    @GetMapping("/{id}/subscriptions")
    public ResponseEntity<List<SubscriptionDto>> getSubscriptions(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getSubscriptions(id));
    }

    @DeleteMapping("/{id}/subscriptions/{subId}")
    public ResponseEntity<Void> deleteSub(@PathVariable Long id, @PathVariable Long subId) {
        userService.deleteSubscription(id, subId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/subscriptions/top")
    public ResponseEntity<List<String>> getTop3() {
        return ResponseEntity.ok(userService.getTopSubscriptions());
    }
}
