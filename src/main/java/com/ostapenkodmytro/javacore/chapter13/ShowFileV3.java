package com.ostapenkodmytro.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFileV3 {
    public static void main(String[] args) throws IOException {
        int i;

        if (args.length != 1) {
            System.out.println("Использование: ShowFile имя_файла");
            return;
        }
        try (var fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
}