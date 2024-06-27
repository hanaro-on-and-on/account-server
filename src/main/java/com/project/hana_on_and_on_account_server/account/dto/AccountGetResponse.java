package com.project.hana_on_and_on_account_server.account.dto;

import com.project.hana_on_and_on_account_server.account.domain.Account;

public record AccountGetResponse(String accountNumber) {

    public static AccountGetResponse fromEntity(Account account){
        return new AccountGetResponse(account.getAccountNumber());
    }
}
