package ru.sberbank.jschool.homework.classloaders.koval;

public class CaesarCipher {
    public static byte[] encrypt(byte[] message, int offset) {
        int len = message.length;
        byte[] res = new byte[len];
        for (int i = 0; i < len; ++i) {
            res[i] = (byte) (message[i] + offset);
        }
        return res;
    }

    public static byte[] decrypt(byte[] message, int offset) {
        int len = message.length;
        byte[] res = new byte[len];
        for (int i = 0; i < len; ++i) {
            res[i] = (byte) (message[i] - offset);
        }
        return res;
    }
}
