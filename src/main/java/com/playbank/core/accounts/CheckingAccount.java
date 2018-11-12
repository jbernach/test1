package com.playbank.core.accounts;

import com.playbank.core.accounts.exceptions.InvalidBalanceException;
import com.playbank.core.accounts.exceptions.InvalidOverdraftLimitException;

import java.math.BigDecimal;

public class CheckingAccount extends AbstractAccount {
    private BigDecimal overdraftLimit = BigDecimal.ZERO;

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) throws InvalidOverdraftLimitException {
        if (overdraftLimit == null || overdraftLimit.signum() < 0) throw new InvalidOverdraftLimitException(overdraftLimit);

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void setBalance(BigDecimal balance) throws InvalidBalanceException {
        if (balance == null || balance.compareTo(overdraftLimit.negate()) < 0) throw new InvalidBalanceException(balance);

        this.balance = balance;
    }
}
