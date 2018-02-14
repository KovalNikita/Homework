package ru.sberbank.homework.koval_nikita;

public class Assert {
    private static final double DELTA = 1e-5;

    public static void assertIntsAreEqual(String message, int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException(message);
        }
    }

    public static void assertDoublesAreEqual(String message, double expected, double actual) {
        if (Math.abs(expected - actual) >= DELTA) {
            throw new RuntimeException(message);
        }
    }
}
