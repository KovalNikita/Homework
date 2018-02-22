package ru.sberbank.homework.koval.exceptions;

public class ServerAccessException extends RuntimeException {
    public ServerAccessException() {
        super();
    }

    public ServerAccessException(String message) {
        super(message);
    }
}
