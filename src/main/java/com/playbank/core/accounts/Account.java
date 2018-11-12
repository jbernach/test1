package com.playbank.core.accounts;

import com.playbank.core.accounts.exceptions.InvalidBalanceException;
import com.playbank.core.accounts.exceptions.InvalidOwnerException;

import java.math.BigDecimal;

public interface Account {
    AccountOwner getOwner();

    void setOwner(AccountOwner owner) throws InvalidOwnerException;

    BigDecimal getBalance();

    void setBalance(BigDecimal balance) throws InvalidBalanceException;
}
