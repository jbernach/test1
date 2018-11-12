package com.playbank.core.accounts

import com.playbank.core.accounts.exceptions.InvalidBalanceException
import com.playbank.core.accounts.exceptions.InvalidOverdraftLimitException
import spock.lang.Specification

class CheckingAccountTest extends Specification {
    public static final int INITIAL_LIMIT = 125
    public static final int NEW_LIMIT = 250
    public static final int INITIAL_BALANCE = 500
    public static final int NEW_BALANCE = 750

    def "test getOverdraftLimit"() {
        given: "a checking account with an overdraft limit"
        CheckingAccount account = new CheckingAccount()
        account.overdraftLimit = new BigDecimal(INITIAL_LIMIT)

        when: "we recover the overdraft limit"
        BigDecimal val = account.getOverdraftLimit()

        then: "the limit is the one stored in the account"
        val.equals(new BigDecimal(INITIAL_LIMIT))
    }


    def "test setOverdraftLimit"() {
        given: "a checking account"
        CheckingAccount account = new CheckingAccount()

        when: "we set the overdraft limit to a valid value"
        account.setOverdraftLimit(new BigDecimal(NEW_LIMIT))

        then: "the limit is stored correctly on the account"
        account.getOverdraftLimit().equals(new BigDecimal(NEW_LIMIT))
    }

    def "test setOverdraftLimit with null value"() {
        given: "a checking account"
        CheckingAccount account = new CheckingAccount()

        when: "we set the overdraft limit to a null value"
        account.setOverdraftLimit(null)

        then: "an exception is thrown"
        thrown(InvalidOverdraftLimitException)
    }

    def "test setOverdraftLimit with negative value"() {
        given: "a checking account"
        CheckingAccount account = new CheckingAccount()

        when: "we set the overdraft limit to a negative value"
        account.setOverdraftLimit(new BigDecimal(-NEW_LIMIT))

        then: "an exception is thrown"
        thrown(InvalidOverdraftLimitException)
    }

    def "test getBalance"() {
        given: "a checking account with a balance"
        CheckingAccount account = new CheckingAccount()
        account.balance = new BigDecimal(INITIAL_BALANCE)

        when: "we recover the balance"
        BigDecimal val = account.getBalance()

        then: "the balance is the one stored in the account"
        val.equals(new BigDecimal(INITIAL_BALANCE))
    }


    def "test setBalance"() {
        given: "a checking account"
        CheckingAccount account = new CheckingAccount()

        when: "we set the balance to a valid value"
        account.setBalance(new BigDecimal(NEW_BALANCE))

        then: "the balance is stored correctly on the account"
        account.getBalance().equals(new BigDecimal(NEW_BALANCE))
    }

    def "test setBalance with null value"() {
        given: "a checking account"
        CheckingAccount account = new CheckingAccount()

        when: "we set the balance to a null value"
        account.setBalance(null)

        then: "an exception is thrown"
        thrown(InvalidBalanceException)
    }

    def "test setBalance using negative values allowed by the overdraft limit"() {
        given: "a checking account"
        CheckingAccount account = new CheckingAccount()
        account.setOverdraftLimit(INITIAL_LIMIT)

        when: "we set the balance to a negative value"
        account.setBalance(new BigDecimal(-INITIAL_LIMIT + 1))

        then: "an exception is thrown"
        account.getBalance().equals(new BigDecimal(-INITIAL_LIMIT + 1))
    }

    def "test setBalance using negative values not allowed by the overdraft limit"() {
        given: "a checking account"
        CheckingAccount account = new CheckingAccount()
        account.setOverdraftLimit(INITIAL_LIMIT)

        when: "we set the balance to a negative value"
        account.setBalance(new BigDecimal(-INITIAL_LIMIT - 1))

        then: "an exception is thrown"
        thrown(InvalidBalanceException)
    }

}
