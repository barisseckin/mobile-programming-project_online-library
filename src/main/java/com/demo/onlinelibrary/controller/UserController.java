package com.demo.onlinelibrary.controller;

import com.demo.onlinelibrary.dto.UserDto;
import com.demo.onlinelibrary.request.CreateUserRequest;
import com.demo.onlinelibrary.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody CreateUserRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String mail) {
        userService.delete(mail);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/send-confirm-code")
    public ResponseEntity<Void> sendConfirmCode(@RequestParam String mail) {
        userService.sendConfirmCode(mail);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    public ResponseEntity<UserDto> activateUser(@RequestParam String mail, @RequestParam int code) {
        return ResponseEntity
                .ok(userService.activateUser(mail, code));
    }
}
