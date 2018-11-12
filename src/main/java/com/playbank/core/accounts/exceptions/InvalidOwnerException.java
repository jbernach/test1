package com.playbank.core.accounts.exceptions;

import com.playbank.core.accounts.AccountOwner;

public class InvalidOwnerException extends AccountException {
    private AccountOwner owner;

    public InvalidOwnerException(AccountOwner owner) {
        this.owner = owner;
    }

    public AccountOwner getOwner() {
        return owner;
    }
}
