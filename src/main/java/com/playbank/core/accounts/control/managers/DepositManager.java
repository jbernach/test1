package com.playbank.core.accounts.control.managers;

import com.playbank.core.accounts.Account;
import com.playbank.core.accounts.exceptions.InvalidBalanceException;
import com.playbank.core.accounts.operations.AccountOperation;
import com.playbank.core.accounts.operations.DepositAccountOperation;

public class DepositManager implements AccountOperationManager {
    @Override
    public boolean supports(AccountOperation operation) {
        return operation instanceof DepositAccountOperation;
    }

    @Override
    public void execute(AccountOperation operation) throws InvalidBalanceException {
        if (operation.isCompleted()) return;

        DepositAccountOperation depositAccountOperation = (DepositAccountOperation)operation;

        Account account = operation.getAccount();

        account.setBalance(account.getBalance().add(depositAccountOperation.getAmount()));

        operation.complete();
    }
}
