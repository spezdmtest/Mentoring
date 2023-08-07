package com.ostapenkodmytro.javacore.chapter18;

import java.util.LinkedList;

public class MailList {
    public static void main(String[] args) {
        LinkedList <Address> ml = new LinkedList<>();

        ml.add(new Address ("J.W.WEST", "11 Oak Ave",
                "Urbana", "IL", "61801"));
        ml.add(new Address ("Ralph Baker", "1142 Maple Lane",
                "Mahomet", "IL", "61853"));
        ml.add(new Address ("Tom Carlton", "867 Elm St",
                "Champaigh", "IL", "61820"));

        for (Address element : ml)
            System.out.println(element + "\n");
        System.out.println();
    }
}