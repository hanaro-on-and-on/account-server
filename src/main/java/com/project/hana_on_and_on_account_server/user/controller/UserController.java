package com.project.hana_on_and_on_account_server.user.controller;

import com.project.hana_on_and_on_account_server.user.dto.*;
import com.project.hana_on_and_on_account_server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserGetResponse> findById(@PathVariable Long userId) {
        UserGetResponse response = userService.findByUserId(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest dto) {
        UserLoginResponse response = userService.login(dto);
        return ResponseEntity.ok(response);
    }
}