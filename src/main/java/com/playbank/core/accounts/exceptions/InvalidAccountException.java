package com.playbank.core.accounts.exceptions;

import com.playbank.core.accounts.Account;

public class InvalidAccountException extends AccountException {
    private Account account;

    public InvalidAccountException(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
