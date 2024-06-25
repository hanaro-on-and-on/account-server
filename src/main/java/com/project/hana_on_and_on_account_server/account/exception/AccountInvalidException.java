package com.project.hana_on_and_on_account_server.account.exception;

import com.project.hana_on_and_on_account_server.common.exception.ValueInvalidException;

public class AccountInvalidException extends ValueInvalidException {

    public AccountInvalidException() {
        super("Invalid Account");
    }

    public AccountInvalidException(Long id) {
        super("Invalid Account"+id);
    }
}
