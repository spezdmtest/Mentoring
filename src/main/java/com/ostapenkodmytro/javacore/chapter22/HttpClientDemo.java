package com.ostapenkodmytro.javacore.chapter22;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HttpClientDemo {
    public static void main(String[] args) throws Exception {
        HttpClient myHC = HttpClient.newHttpClient();
        HttpRequest myReq = HttpRequest.newBuilder(new URI("https://www.internic.net")).build();
//        HttpResponse<InputStream> myResp = myHC.send(myReq, HttpResponse.BodyHandlers.ofInputStream()
//        HttpResponse<String> myResp = myHC.send(myReq, HttpResponse.BodyHandlers.ofString());
        HttpResponse<Stream<String>> myResp = myHC.send(myReq, HttpResponse.BodyHandlers.ofLines());
        System.out.println("Код ответа: " + myResp.statusCode());
        System.out.println("Метод запроса: " + myReq.method());
        HttpHeaders hdrs = myResp.headers();
        Map<String, List<String>> hdrMap = hdrs.map();
        System.out.println("\nЗаголовок:");
        for (String k : hdrMap.keySet()) {
            System.out.println(" Ключ: " + k + " Значение: " + hdrMap.get(k));
        }
        System.out.println("\nТело: ");
/*
        InputStream input = myResp.body();
        int c;
        while ((c = input.read()) != -1) {
            System.out.print((char) c);
        }
*/
        myResp.body().forEach(System.out::println);
    }
}
