package com.playbank.core.accounts.control;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Duration;

public class BasicInterestCalculator implements InterestCalculator {
    private int precision = 3;
    private RoundingMode roundingMode = RoundingMode.HALF_UP;

    @Override
    public BigDecimal getInterestAmount(BigDecimal amount, Duration period, BigDecimal yearInterestRate) {
        BigDecimal dailyInterestRate = yearInterestRate
                .divide(new BigDecimal(365), MathContext.DECIMAL128)
                .divide(new BigDecimal(100), MathContext.DECIMAL128);

        return amount.multiply(dailyInterestRate.multiply(new BigDecimal(period.toDays())))
                .round(new MathContext(precision, roundingMode));
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }
}
