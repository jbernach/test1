package com.playbank.core.accounts.operations;

import com.playbank.core.accounts.Account;

public interface AccountOperation {
    Account getAccount();

    boolean isCompleted();

    void complete();
}
