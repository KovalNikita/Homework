package ru.sberbank.homework.koval.exceptions;

public class AccountAccessException extends RuntimeException {
    public AccountAccessException() {
        super();
    }

    public AccountAccessException(String message) {
        super(message);
    }
}
