package ru.sberbank.jschool.homework.classloaders.koval.test;

public class Assert {
    public static void arraysAreEqual(String message, byte[] expected, byte[] actual) {
        if (expected.length != actual.length) {
            throw new RuntimeException(message);
        }
        int length = expected.length;
        for (int i = 0; i < length; ++i) {
            if (expected[i] != actual[i]) {
                throw new RuntimeException(message);
            }
        }
    }
}
