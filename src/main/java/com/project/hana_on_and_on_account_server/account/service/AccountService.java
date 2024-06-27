package com.project.hana_on_and_on_account_server.account.service;

import com.project.hana_on_and_on_account_server.account.domain.Account;
import com.project.hana_on_and_on_account_server.account.dto.AccountGetResponse;
import com.project.hana_on_and_on_account_server.account.repository.AccountRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<AccountGetResponse> getUserAccountList(Long userId) {
        List<Account> accountList = accountRepository.findByUserUserId(userId);
        return accountList.stream().map(AccountGetResponse::fromEntity).toList();
    }
}
