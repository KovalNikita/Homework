package ru.sberbank.jschool.homework.classloaders.koval;

import java.io.*;

public class EncryptedClassLoader extends ClassLoader {
    private String classPath;
    private int offset;

    public EncryptedClassLoader(int offset, String classPath, ClassLoader parent) {
        super(parent);
        this.classPath = classPath;
        this.offset = offset;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            String[] pathSequence = className.split("\\.");
            String fileName = pathSequence[pathSequence.length - 1];

            byte encryptedClassCode[] = readClassFromFile(classPath + fileName + ".class");
            byte decryptedClassCode[] = CaesarCipher.decrypt(encryptedClassCode, this.offset);
            return defineClass(className, decryptedClassCode,
                    0, decryptedClassCode.length);
        } catch (IOException ex) {
            return super.findClass(className);
        }
    }

    private byte[] readClassFromFile(String classPath) throws IOException {
        File file = new File(classPath);
        byte[] bytes = new byte[(int) file.length()];

        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);
        fis.close();
        return bytes;
    }
}
