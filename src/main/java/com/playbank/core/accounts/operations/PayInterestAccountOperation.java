package com.playbank.core.accounts.operations;

import com.playbank.core.accounts.SavingAccount;
import com.playbank.core.accounts.exceptions.InvalidAccountException;
import com.playbank.core.accounts.exceptions.InvalidDateException;

import java.time.LocalDate;

public class PayInterestAccountOperation extends OneTimeAccountOperation {
    private LocalDate timeToApply;

    public PayInterestAccountOperation(SavingAccount account, LocalDate timeToApply) throws InvalidAccountException,
            InvalidDateException {
        this.timeToApply = timeToApply;
        if (account == null) throw new InvalidAccountException(account);
        if (timeToApply == null) throw new InvalidDateException(timeToApply);

        this.account = account;
        this.timeToApply = timeToApply;
    }

    @Override
    public boolean isCompleted() {
        return super.isCompleted() &&
                timeToApply.compareTo(((SavingAccount)this.account).getLastInterestPayment()) <= 0;
    }

    public LocalDate getTimeToApply() {
        return timeToApply;
    }
}
