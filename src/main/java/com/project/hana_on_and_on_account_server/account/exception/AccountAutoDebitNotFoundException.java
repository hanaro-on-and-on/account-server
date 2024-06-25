package com.project.hana_on_and_on_account_server.account.exception;

import com.project.hana_on_and_on_account_server.common.exception.EntityNotFoundException;

public class AccountAutoDebitNotFoundException extends EntityNotFoundException {

    public AccountAutoDebitNotFoundException() {
        super("Could not found AccountAutoDebit");
    }

    public AccountAutoDebitNotFoundException(Long id) {
        super("Could not found AccountAutoDebit"+id);
    }
}

