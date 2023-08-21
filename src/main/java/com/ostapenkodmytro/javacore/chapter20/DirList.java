package com.ostapenkodmytro.javacore.chapter20;

import java.io.File;

public class DirList {
    public static void main(String[] args) {
        String dirname = "C:/Users/spezdm/IdeaProjects/Mentoring/src/main/java/";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("Каталог " + dirname);
            String[] s = f1.list();

            for (String value : s) {
                File f = new File(dirname + "/" + value);
                if (f.isDirectory()) {
                    System.out.println(value + " является каталогом");
                } else {
                    System.out.println(value + " является файлом");
                }
            }
        } else {
            System.out.println(dirname + " не является каталогом");
        }
    }
}