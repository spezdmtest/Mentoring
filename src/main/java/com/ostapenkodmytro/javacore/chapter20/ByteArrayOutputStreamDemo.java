package com.ostapenkodmytro.javacore.chapter20;


import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "Эти данные должны быть выведены в массив";
        byte[] buf = s.getBytes();

        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("Ошибка записи в буфер");
        }

        System.out.println("Буфер в виде символьной строки");
        System.out.println(f);

        System.out.println("В массив");

//        byte[] b = f.toByteArray();
//        for (byte value : b) System.out.print((char) value);

        try (FileOutputStream f2 = new FileOutputStream("test2.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
            return;
        }
        System.out.println();
        System.out.println("Установка в исходное состояние");
        f.reset();
        for (int i = 0; i < 3; i++) f.write('X');
        System.out.println(f);
    }
}
