package com.ostapenkodmytro.javacore.chapter18;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class TreeMapDemo2B {
    public static void main(String[] args) {
        Comparator<String> compLastThenFirst = Comparator
                .comparing((String str) -> str.substring(str.lastIndexOf(' ')))
                .thenComparing(Comparator.naturalOrder());
        TreeMap<String, Double> tm = new TreeMap<>(compLastThenFirst);
        tm.put("Джон Доу", 3434.34);
        tm.put("Том Смит", 123.22);
        tm.put("Джейн Бейкер", 1378.00);
        tm.put("Тод Халл", 99.22);
        tm.put("Ральф Смит", -19.08);

//        Set <Map.Entry<String,Double>> set = tm.entrySet();
//        for(Map.Entry<String,Double> me : set ) {
//            System.out.print(me.getKey() + ": ");
//            System.out.println(me.getValue());
//        }
        tm.forEach((key, value) -> {
            System.out.print(key + ": ");
            System.out.println(value);
        });
        System.out.println();

        double balance = tm.get("Джон Доу");
        tm.put("Джон Доу",  balance + 1000);

        System.out.println("Новый остаток на счете Джона Доу: " + tm.get("Джон Доу"));
    }
}