package com.ostapenkodmytro.javacore.chapter18;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        System.out.println("Начальный размер списочного массива al: " + al.size());

        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");
        System.out.println("Размер списочного массива al после ввода элементов: " + al.size());

        System.out.println("Содержимое списочного массива al: " + al);

        al.remove("F");
        al.remove(2);

        System.out.println("Размер списочного массива al после ввода элементов: " + al.size());
        System.out.println("Содержимое списочного массива al: " + al);
        Collections.sort(al);
        System.out.println("Отсортированный массив: " + al);
    }
}