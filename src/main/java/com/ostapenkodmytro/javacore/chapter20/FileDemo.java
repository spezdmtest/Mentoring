package com.ostapenkodmytro.javacore.chapter20;

import java.io.File;

public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("C:/Users/spezdm/IdeaProjects/Mentoring/src/main/java/COPYRIGHT");
        p("Имя файла: " + f1.getName());
        p("Путь: " + f1.getPath());
        p("Абсолютный путь: " + f1.getAbsolutePath());
        p("Родительский каталог: " + f1.getParent());
        p(f1.exists() ? "существует" : "не существует");
        p(f1.canWrite() ? "доступен для записи" : "не доступен для записи");
        p(f1.canRead() ? "доступен для чтения" : "не доступен для чтения");
        p(f1.isDirectory() ? "является каталоком" : "не является каталогом");
        p(f1.isFile() ? "является обычным файлом" : "не является обычным файлом");
        p(f1.isAbsolute() ? "является абсолютным" : "не является абсолютным");
        p("Последние изменение в файле: " + f1.lastModified());
        p("Размер: " + f1.length() + "байт");
    }
}