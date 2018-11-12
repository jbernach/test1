package com.playbank.core.accounts.control.managers;

import com.playbank.core.accounts.Account;
import com.playbank.core.accounts.CheckingAccount;
import com.playbank.core.accounts.exceptions.InsufficientBalanceException;
import com.playbank.core.accounts.exceptions.InvalidBalanceException;
import com.playbank.core.accounts.operations.AccountOperation;
import com.playbank.core.accounts.operations.WithdrawAccountOperation;

import java.math.BigDecimal;

public class WithdrawManager implements AccountOperationManager {
    @Override
    public boolean supports(AccountOperation operation) {
        return operation instanceof WithdrawAccountOperation;
    }

    @Override
    public void execute(AccountOperation operation) throws InsufficientBalanceException, InvalidBalanceException {
        if (operation.isCompleted()) return;

        WithdrawAccountOperation withdrawAccountOperation = (WithdrawAccountOperation)operation;

        Account account = operation.getAccount();

        if (account instanceof CheckingAccount) {
            CheckingAccount checkingAccount = (CheckingAccount)account;

            BigDecimal remain = account.getBalance().add(checkingAccount.getOverdraftLimit());
            remain = remain.subtract(withdrawAccountOperation.getAmount());

            if (remain.compareTo(BigDecimal.ZERO) < 0) {
                throw new InsufficientBalanceException(account.getBalance());
            }
        } else {
            BigDecimal remain = account.getBalance().subtract(withdrawAccountOperation.getAmount());

            if (remain.compareTo(BigDecimal.ZERO) < 0) {
                throw new InsufficientBalanceException(account.getBalance());
            }
        }

        account.setBalance(account.getBalance().subtract(withdrawAccountOperation.getAmount()));

        operation.complete();
    }
}
