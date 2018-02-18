package ru.sberbank.homework.common;

public class ExpressionFormatException extends IllegalArgumentException {
    public ExpressionFormatException() {
        super();
    }

    public ExpressionFormatException(String message) {
        super(message);
    }
}