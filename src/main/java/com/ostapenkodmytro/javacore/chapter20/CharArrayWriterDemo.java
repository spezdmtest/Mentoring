package com.ostapenkodmytro.javacore.chapter20;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter f = new CharArrayWriter();
        String s = "Эти данные должны быть выведены в массив";
        char[] buf = new char[s.length()];

        s.getChars(0, s.length(), buf, 0);
        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Ошибка записи в буфер");
            return;
        }

        System.out.println("Буфер в виде символьной строки");
        System.out.println(f);

        char[] c = f.toCharArray();
        for (char value : c) {
            System.out.print(value);
        }

        System.out.println("\nВ поток вывода типа FileWriter()");

        try (FileWriter f2 = new FileWriter("test2.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }

        System.out.println("Установка в исходное состояние");
        f.reset();

        for (int i = 0; i < 3; i++) f.write('X');
        System.out.println(f);
    }
}