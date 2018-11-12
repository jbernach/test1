package com.playbank.core.accounts.operations;

import com.playbank.core.accounts.exceptions.InvalidAccountException;
import com.playbank.core.accounts.exceptions.InvalidDepositAmountException;
import com.playbank.core.accounts.Account;

import java.math.BigDecimal;

public class DepositAccountOperation extends OneTimeAccountOperation {
    protected BigDecimal amount;

    public DepositAccountOperation(Account account, BigDecimal amount) throws InvalidAccountException, InvalidDepositAmountException {
        if (account == null) throw new InvalidAccountException(account);

        if (amount == null || amount.signum() <= 0) throw  new InvalidDepositAmountException(amount);

        this.account = account;

        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }
}
