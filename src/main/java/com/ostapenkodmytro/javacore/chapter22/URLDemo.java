package com.ostapenkodmytro.javacore.chapter22;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL hp = new URL("https://www.HerbSchild.com:8080/");
        System.out.println("Протокол: " + hp.getProtocol());
        System.out.println("Порт: " + hp.getPort());
        System.out.println("Хост: " + hp.getHost());
        System.out.println("Полная форма: " + hp.toExternalForm());
    }
}