package com.playbank.core.accounts.exceptions;

import java.math.BigDecimal;

public class InvalidDepositAmountException extends AccountException {
    private BigDecimal amount;

    public InvalidDepositAmountException(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
