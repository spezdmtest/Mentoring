package com.ostapenkodmytro.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail {
    String name;
    String phonenum;
    String email;

    public NamePhoneEmail(String n, String p, String e) {
        this.name = n;
        this.phonenum = p;
        this.email = e;
    }
}

class NamePhone {
    String name;
    String phonenum;

    public NamePhone(String n, String p) {
        this.name = n;
        this.phonenum = p;
    }
}

public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Ларри", "555-5555",
                "Larry@HerbShildt.com"));
        myList.add(new NamePhoneEmail("Джеймс", "555-4444",
                "James@HerbShildt.com"));
        myList.add(new NamePhoneEmail("Мэри", "555-3333",
                "Mary@HerbShildt.com"));

        System.out.println("Исходные элементы из списка myList: ");
        myList.forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum + " " + a.email);
        });
        System.out.println();

        Stream<NamePhone> nameAndPhone = myList.stream()
                .filter((a) -> a.name.equals("Джеймс"))
                .map((a) -> new NamePhone(a.name, a.phonenum));
        System.out.println("Список имен и номеров телефонов: ");
        nameAndPhone.forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum);
        });
    }
}