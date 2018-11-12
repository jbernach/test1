package com.playbank.core.accounts;

import com.playbank.core.accounts.exceptions.InvalidDateException;
import com.playbank.core.accounts.exceptions.InvalidInterestRateException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SavingAccount extends AbstractAccount {
    private BigDecimal yearInterestRate = BigDecimal.ZERO;
    private LocalDate lastInterestPayment = LocalDate.now();

    public BigDecimal getYearInterestRate() {
        return this.yearInterestRate;
    }

    public void setYearInterestRate(BigDecimal yearInterestRate) throws InvalidInterestRateException {
        if (yearInterestRate == null) throw new InvalidInterestRateException(yearInterestRate);

        this.yearInterestRate = yearInterestRate;
    }

    public LocalDate getLastInterestPayment() {
        return this.lastInterestPayment;
    }

    public void setLastInterestPayment(LocalDate lastInterestPayment) throws InvalidDateException {
        if (lastInterestPayment == null) throw new InvalidDateException(lastInterestPayment);

        this.lastInterestPayment = lastInterestPayment;
    }
}
