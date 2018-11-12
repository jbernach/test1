package com.playbank.core.accounts.exceptions;

import java.math.BigDecimal;

public class InvalidInterestRateException extends AccountException {
    private BigDecimal rate;

    public InvalidInterestRateException(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return this.rate;
    }
}
