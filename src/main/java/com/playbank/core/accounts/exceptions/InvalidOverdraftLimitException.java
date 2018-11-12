package com.playbank.core.accounts.exceptions;

import java.math.BigDecimal;

public class InvalidOverdraftLimitException extends AccountException {
    private BigDecimal limit;

    public InvalidOverdraftLimitException(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getLimit() {
        return this.limit;
    }
}
