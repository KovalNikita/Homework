package ru.sberbank.jschool.homework.classloaders.koval;

public class Application {
    public static void main(String[] argv) throws PluginNotFoundException {

        String[] urls = {"https://www.youtube.com/", "https://www.google.ru"};

        String rootDirectory = "user_plugins";
        PluginManager manager = new PluginManager(rootDirectory);

        Plugin counter = manager.loadPlugin("counter");
        counter.run(urls);

        Plugin printer = manager.loadPlugin("printer");
        printer.run(urls);

        Plugin newCounter = manager.loadPlugin("counter");
        newCounter.run(urls);

    }
}
