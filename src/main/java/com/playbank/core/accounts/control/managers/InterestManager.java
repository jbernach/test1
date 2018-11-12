package com.playbank.core.accounts.control.managers;

import com.playbank.core.accounts.SavingAccount;
import com.playbank.core.accounts.control.BasicInterestCalculator;
import com.playbank.core.accounts.control.InterestCalculator;
import com.playbank.core.accounts.exceptions.InvalidBalanceException;
import com.playbank.core.accounts.operations.AccountOperation;
import com.playbank.core.accounts.operations.PayInterestAccountOperation;

import java.math.BigDecimal;
import java.time.Duration;

public class InterestManager implements AccountOperationManager {
    InterestCalculator interestCalculator = new BasicInterestCalculator();

    @Override
    public boolean supports(AccountOperation operation) {
        return operation instanceof PayInterestAccountOperation;
    }

    @Override
    public void execute(AccountOperation operation) throws InvalidBalanceException {
        if (operation.isCompleted()) return;

        PayInterestAccountOperation payInterestAccountOperation = (PayInterestAccountOperation)operation;

        SavingAccount account = (SavingAccount)operation.getAccount();

        BigDecimal interestAmount = interestCalculator.getInterestAmount(
                account.getBalance(),
                Duration.between(account.getLastInterestPayment(), payInterestAccountOperation.getTimeToApply()),
                account.getYearInterestRate());


        account.setBalance(account.getBalance().add(interestAmount));


        operation.complete();
    }
}
