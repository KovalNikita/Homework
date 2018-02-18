package ru.sberbank.homework.common;

public class Assert {

    public static void assertStringsAreEqual(String message, String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new RuntimeException(message);
        }
    }
}