package com.playbank.core.accounts;

import com.playbank.core.accounts.exceptions.InvalidBalanceException;
import com.playbank.core.accounts.exceptions.InvalidDepositAmountException;
import com.playbank.core.accounts.exceptions.InvalidOwnerException;

import java.math.BigDecimal;

public abstract class AbstractAccount implements Account {
    protected Long id;
    protected AccountOwner owner;
    protected BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountOwner getOwner() {
        return owner;
    }

    public void setOwner(AccountOwner owner) throws InvalidOwnerException {
        if (owner == null) throw new InvalidOwnerException(owner);

        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) throws InvalidBalanceException {
        if (balance == null || balance.signum() <= 0) throw new InvalidBalanceException(balance);

        this.balance = balance;
    }
}
