package ru.sberbank.homework.koval.exceptions;

public class AccountIsLockedException extends RuntimeException {
    public AccountIsLockedException() {
        super();
    }

    public AccountIsLockedException(String message) {
        super(message);
    }
}
