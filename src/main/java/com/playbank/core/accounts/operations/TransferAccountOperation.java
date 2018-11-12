package com.playbank.core.accounts.operations;

import com.playbank.core.accounts.CheckingAccount;
import com.playbank.core.accounts.exceptions.InvalidAccountException;
import com.playbank.core.accounts.exceptions.InvalidDepositAmountException;

import java.math.BigDecimal;

public class TransferAccountOperation extends OneTimeAccountOperation {
    protected WithdrawAccountOperation withdrawAccountOperation;
    protected DepositAccountOperation depositAccountOperation;

    public TransferAccountOperation(CheckingAccount origin, CheckingAccount destination, BigDecimal amount)
            throws InvalidAccountException, InvalidDepositAmountException {

        this.withdrawAccountOperation = new WithdrawAccountOperation(origin, amount);

        this.depositAccountOperation = new DepositAccountOperation(destination, amount);
    }

    public CheckingAccount getOriginAccount() {
        return (CheckingAccount) this.withdrawAccountOperation.getAccount();
    }

    public CheckingAccount getDestinationAccount() {
        return (CheckingAccount) this.depositAccountOperation.getAccount();
    }

    public WithdrawAccountOperation getWithdrawAccountOperation() {
        return this.withdrawAccountOperation;
    }

    public DepositAccountOperation getDepositAccountOperation() {
        return this.depositAccountOperation;
    }

    @Override
    public boolean isCompleted() {
        return this.withdrawAccountOperation.isCompleted() && this.depositAccountOperation.isCompleted();
    }

    @Override
    public void complete() {
        this.withdrawAccountOperation.complete();
        this.depositAccountOperation.complete();
    }

}
