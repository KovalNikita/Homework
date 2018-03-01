package ru.sberbank.jschool.homework.classloaders.koval;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class PluginManager {

    // directory that contains plugin folders
    private final String rootDirectory;
    private final ClassLoader classLoader;

    PluginManager(String rootDirectory) {
        this.rootDirectory = rootDirectory;
        this.classLoader = new PluginClassLoader(this.rootDirectory);
    }

    /**
     * method takes as a parameter a folder name in the root plugin directory,
     * loads the plugin .class file from the folder if present,
     * and returns a Plugin object
     *
     * @param pluginName - name of the plugin folder
     * @return Plugin
     * @throws PluginNotFoundException - when folder named 'pluginName' is missing,
     *                                 or it contains no .class files
     */
    public Plugin loadPlugin(String pluginName) throws PluginNotFoundException {
        Plugin plugin;
        try {
            String pluginPath = rootDirectory + "\\" + pluginName + "\\";
            File folder = new File(pluginPath);

            File[] files = folder.listFiles();
            if (files == null) {
                throw new PluginNotFoundException("couldn't locate plugin " + pluginName);
            }
            String suffix = ".class";
            List<String> fileNames = Arrays
                    .stream(files)
                    .map(File::getName)
                    .filter(name -> name.endsWith(suffix))
                    .collect(Collectors.toList());

            if (fileNames.size() != 1) {
                throw new PluginNotFoundException("couldn't locate plugin " + pluginName);
            }
            String fileName = fileNames.get(0);
            String className = fileName.substring(0, fileName.length() - suffix.length());

            Class<?> clazz = classLoader.loadClass(rootDirectory + "." + pluginName + "." + className);
            plugin = (Plugin) clazz.getConstructor().newInstance();
        } catch (NoSuchMethodException |
                InstantiationException |
                InvocationTargetException |
                IllegalAccessException |
                ClassNotFoundException e) {
            throw new PluginNotFoundException("couldn't locate plugin " + pluginName, e);
        }
        return plugin;
    }
}
