package ru.sberbank.homework.koval;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SiteViewer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String url = scanner.nextLine();
                readPage(url);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void readPage(String url) {
        URL urlRequest;
        try {
            urlRequest = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Проблемы с доступом к " + url);
        }

        try (InputStream urlStream = urlRequest.openStream();
             BufferedReader urlReader = new BufferedReader(
                     new InputStreamReader(urlStream))) {

            while (urlReader.ready()) {
                String inputLine = urlReader.readLine();
                System.out.println(inputLine);
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении потока. Попробуйте выполнить кокманду еще раз");
        }
    }
}
