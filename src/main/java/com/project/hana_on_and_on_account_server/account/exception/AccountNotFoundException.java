package com.project.hana_on_and_on_account_server.account.exception;

import com.project.hana_on_and_on_account_server.common.exception.EntityNotFoundException;

public class AccountNotFoundException extends EntityNotFoundException {

    public AccountNotFoundException() {
        super("Could not found Account");
    }

    public AccountNotFoundException(Long id) {
        super("Could not found Account"+id);
    }
}
