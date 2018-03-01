package ru.sberbank.jschool.homework.classloaders.koval.test;

import ru.sberbank.jschool.homework.classloaders.koval.CaesarCipher;

public class TestCaesarCipher {
    public static void run() {
        simpleTest();
        overflowTest();
        System.out.println("all tests were passed successfully");
    }

    private static void simpleTest() {
        int offset = 20;
        byte[] bytes = {10, 20, 30, 40, 50, 60};
        checkMessage(bytes, offset, "simpleTest was failed");
    }

    private static void overflowTest() {
        int offset = 100;
        byte[] bytes = {10, 100, -50, -120};
        checkMessage(bytes, offset, "overflowTest was failed");
    }

    private static void checkMessage(byte[] bytes, int offset, String message) {
        byte[] encryptedBytes = CaesarCipher.encrypt(bytes, offset);
        byte[] decryptedBytes = CaesarCipher.decrypt(encryptedBytes, offset);
        Assert.arraysAreEqual(message, bytes, decryptedBytes);
    }


}
