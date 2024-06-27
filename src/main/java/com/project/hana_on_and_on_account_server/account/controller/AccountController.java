package com.project.hana_on_and_on_account_server.account.controller;

import com.project.hana_on_and_on_account_server.account.dto.AccountGetResponse;
import com.project.hana_on_and_on_account_server.account.service.AccountService;
import com.project.hana_on_and_on_account_server.user.dto.UserLoginRequest;
import com.project.hana_on_and_on_account_server.user.dto.UserLoginResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<AccountGetResponse>> getUserAccountList(@PathVariable Long userId) {
        List<AccountGetResponse> response = accountService.getUserAccountList(userId);
        return ResponseEntity.ok(response);
    }
}