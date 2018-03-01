package ru.sberbank.homework.koval;

public class ExpressionFormatException extends IllegalArgumentException {
    public ExpressionFormatException() {
        super();
    }

    public ExpressionFormatException(String message) {
        super(message);
    }
}