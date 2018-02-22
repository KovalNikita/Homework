package ru.sberbank.homework.koval.logger;

public class ConsoleLogger implements Logger {
    public void sendMessage(String m) {
        System.out.println(m);
    }
}
