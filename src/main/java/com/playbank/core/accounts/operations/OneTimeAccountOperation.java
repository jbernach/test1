package com.playbank.core.accounts.operations;

import com.playbank.core.accounts.Account;

import java.time.Instant;

public class OneTimeAccountOperation implements AccountOperation {
    protected Long id;

    protected Instant timeStamp = Instant.now();
    protected Account account;
    protected boolean completed = false;

    @Override
    public Account getAccount() {
        return this.account;
    }

    @Override
    public boolean isCompleted() {
        return this.completed;
    }

    public void complete() {
        this.completed = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
