package ru.sberbank.homework.koval;

public class Assert {

    public static void assertStringsAreEqual(String message, String actual, String expected) {
        if (!actual.equals(expected)) {
            throw new RuntimeException(message);
        }
    }
}