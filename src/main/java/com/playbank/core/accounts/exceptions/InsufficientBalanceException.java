package com.playbank.core.accounts.exceptions;

import java.math.BigDecimal;

public class InsufficientBalanceException extends AccountOperationException {
    private BigDecimal balance;

    public InsufficientBalanceException(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }
}
