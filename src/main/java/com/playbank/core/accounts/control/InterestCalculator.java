package com.playbank.core.accounts.control;

import java.math.BigDecimal;
import java.time.Duration;

public interface InterestCalculator {
    BigDecimal getInterestAmount(BigDecimal amount, Duration period, BigDecimal yearInterestRate);
}
