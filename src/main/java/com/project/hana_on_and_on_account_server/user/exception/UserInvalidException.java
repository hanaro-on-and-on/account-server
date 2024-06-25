package com.project.hana_on_and_on_account_server.user.exception;

import com.project.hana_on_and_on_account_server.common.exception.ValueInvalidException;

public class UserInvalidException extends ValueInvalidException {

    public UserInvalidException() {
        super("Invalid User");
    }

    public UserInvalidException(Long id) {
        super("Invalid User"+id);
    }
}
