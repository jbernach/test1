package com.playbank.core.accounts.exceptions;

import java.time.LocalDate;

public class InvalidDateException extends AccountException {
    private LocalDate date;

    public InvalidDateException(LocalDate date) {
        this.date = date;
    }


    public LocalDate getDate() {
        return date;
    }
}
