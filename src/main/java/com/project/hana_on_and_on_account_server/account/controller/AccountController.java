package com.project.hana_on_and_on_account_server.account.controller;

import com.project.hana_on_and_on_account_server.account.dto.AccountDebitRequest;
import com.project.hana_on_and_on_account_server.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/account-debit")
    public ResponseEntity<Void> processAccountDebit (@RequestBody AccountDebitRequest accountDebitRequest){
        accountService.processAccountDebit(accountDebitRequest);
        return ResponseEntity.noContent().build();
    }
}
