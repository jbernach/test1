package com.playbank.core.accounts.control

import spock.lang.Specification

import java.math.MathContext
import java.time.Duration

class BasicInterestCalculatorTest extends Specification {
    def "test getInterestAmount"() {
        given: "an interest calculator"
        BasicInterestCalculator calculator = new BasicInterestCalculator()

        expect:
        calculator.getInterestAmount(new BigDecimal(amount), period, new BigDecimal(yearRate)) ==
                new BigDecimal(interestAmount, new MathContext(calculator.getPrecision(), calculator.getRoundingMode()))

        where:
        amount | period               | yearRate | interestAmount
        "100"  | Duration.ofDays(365) | "15"     | "15"
        "500"  | Duration.ofDays(30)  | "8.5"    | "3.49"
        "479200.1"  | Duration.ofDays(90)  | "3.25"| "3840.16"
    }
}
