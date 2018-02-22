package ru.sberbank.homework.koval.exceptions;

public class TerminalOperationException extends RuntimeException {
    public TerminalOperationException() {
        super();
    }

    public TerminalOperationException(String message) {
        super(message);
    }
}
