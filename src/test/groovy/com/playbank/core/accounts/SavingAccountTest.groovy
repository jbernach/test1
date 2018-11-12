package com.playbank.core.accounts

import com.playbank.core.accounts.exceptions.InvalidBalanceException
import com.playbank.core.accounts.exceptions.InvalidInterestRateException
import spock.lang.Specification

class SavingAccountTest extends Specification {
    public static final int INITIAL_BALANCE = 500
    public static final int NEW_BALANCE = 750
    public static final int INITIAL_INTEREST = 15
    public static final int NEW_INTEREST = 5

    def "test getBalance"() {
        given: "a saving account with a balance"
        SavingAccount account = new SavingAccount()
        account.balance = new BigDecimal(INITIAL_BALANCE)

        when: "we recover the balance"
        BigDecimal val = account.getBalance()

        then: "the balance is the one stored in the account"
        val.equals(new BigDecimal(INITIAL_BALANCE))
    }


    def "test setBalance"() {
        given: "a saving account"
        SavingAccount account = new SavingAccount()

        when: "we set the balance to a valid value"
        account.setBalance(new BigDecimal(NEW_BALANCE))

        then: "the balance is stored correctly on the account"
        account.getBalance().equals(new BigDecimal(NEW_BALANCE))
    }

    def "test setBalance with null value"() {
        given: "a saving account"
        SavingAccount account = new SavingAccount()

        when: "we set the balance to a null value"
        account.setBalance(null)

        then: "an exception is thrown"
        thrown(InvalidBalanceException)
    }

    def "test setBalance with negative value"() {
        given: "a saving account"
        SavingAccount account = new SavingAccount()

        when: "we set the balance to a negative value"
        account.setBalance(new BigDecimal(-NEW_BALANCE))

        then: "an exception is thrown"
        thrown(InvalidBalanceException)
    }

    def "test getYearInterestRate"() {
        given: "a saving account with an interest rate"
        SavingAccount account = new SavingAccount()
        account.yearInterestRate = new BigDecimal(INITIAL_INTEREST)

        when: "we recover the interest rate"
        BigDecimal val = account.getYearInterestRate()

        then: "the interest rate is the one stored in the account"
        val.equals(new BigDecimal(INITIAL_INTEREST))
    }


    def "test setYearInterestRate"() {
        given: "a saving account"
        SavingAccount account = new SavingAccount()

        when: "we set the interest to a valid value"
        account.setYearInterestRate(new BigDecimal(NEW_INTEREST))

        then: "the interest is stored correctly on the account"
        account.getYearInterestRate().equals(new BigDecimal(NEW_INTEREST))
    }

    def "test setYearInterestRate with null value"() {
        given: "a saving account"
        SavingAccount account = new SavingAccount()

        when: "we set the interest rate to a null value"
        account.setYearInterestRate(null)

        then: "an exception is thrown"
        thrown(InvalidInterestRateException)
    }
}
