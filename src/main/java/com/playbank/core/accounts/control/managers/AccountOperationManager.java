package com.playbank.core.accounts.control.managers;

import com.playbank.core.accounts.exceptions.InsufficientBalanceException;
import com.playbank.core.accounts.exceptions.InvalidBalanceException;
import com.playbank.core.accounts.operations.AccountOperation;

public interface AccountOperationManager {
    boolean supports(AccountOperation operation);

    void execute(AccountOperation operation) throws InsufficientBalanceException, InvalidBalanceException;
}
