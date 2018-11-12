package com.playbank.core.accounts.exceptions;

import java.math.BigDecimal;

public class InvalidBalanceException extends AccountException {
    private BigDecimal balance;

    public InvalidBalanceException(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }
}
