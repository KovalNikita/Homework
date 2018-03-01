package ru.sberbank.jschool.homework.classloaders.koval;


import ru.sberbank.jschool.homework.classloaders.koval.test.TestCaesarCipher;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Application {
    private static final String SRC_CLASSES_PATH = "src_classes\\";
    private static final String ENCRYPTED_CLASSES_PATH = "encrypted_classes\\";
    private static final String PACKAGE_NAME = "encrypted_classes";
    private static final int OFFSET = 97;

    public static void main(String[] argv) {
        TestCaesarCipher.run();
        String userClassName = "UserPlugin";
        String[] urls = {"https://www.youtube.com/", "https://www.google.ru"};
        encryptClassFile(userClassName);

        try {
            ClassLoader pluginClassLoader = Plugin.class.getClassLoader();
            EncryptedClassLoader classLoader = new EncryptedClassLoader(OFFSET, ENCRYPTED_CLASSES_PATH,
                    pluginClassLoader);

            Class<?> clazz = classLoader.loadClass(PACKAGE_NAME + "." + userClassName);
            Plugin execute = (Plugin) clazz.getConstructor().newInstance();

            execute.run(urls);
        } catch (NoSuchMethodException |
                InstantiationException |
                ClassNotFoundException |
                InvocationTargetException |
                IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    static private void encryptClassFile(String className) {

        File inputFile = new File(SRC_CLASSES_PATH + className + ".class");
        File outputFile = new File(ENCRYPTED_CLASSES_PATH + className + ".class");

        byte[] bytes = new byte[(int) inputFile.length()];

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            fis.read(bytes);
            byte[] encryptedBytes = CaesarCipher.encrypt(bytes, OFFSET);
            fos.write(encryptedBytes);

        } catch (IOException ex) {
            throw new RuntimeException("couldn't encrypt class " + className, ex);
        }
    }
}
