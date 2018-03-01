package ru.sberbank.jschool.homework.classloaders.koval;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PluginClassLoader extends ClassLoader {
    private final String rootDirectory;
    private final Map<String, Class<?>> classes;

    PluginClassLoader(String rootDirectory) {
        super(Plugin.class.getClassLoader());
        this.rootDirectory = rootDirectory;
        this.classes = new HashMap<>();
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String classPath = name.replace(".", "\\") + ".class";
            byte classCode[] = readClassFromFile(classPath);
            return defineClass(name, classCode,
                    0, classCode.length);
        } catch (IOException ex) {
            return super.findClass(name);
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class<?> clazz;
        if (!name.startsWith(this.rootDirectory)) {
            return super.loadClass(name, resolve);
        }
        if (classes.containsKey(name)) {
            clazz = classes.get(name);
        } else {
            clazz = this.findClass(name);
            classes.put(name, clazz);
        }
        if (resolve) {
            resolveClass(clazz);
        }
        return clazz;
    }

    private byte[] readClassFromFile(String path) throws IOException {
        File file = new File(path);
        byte[] bytes = new byte[(int) file.length()];

        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);
        fis.close();
        return bytes;
    }
}
