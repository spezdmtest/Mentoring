package com.ostapenkodmytro.javacore.chapter20;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackReaderDemo {
    public static void main(String[] args) {
        String s = "if (a == 4) a = 0;\n";
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        CharArrayReader in = new CharArrayReader(buf);
        int c;

        try (PushbackReader f = new PushbackReader(in)) {
            while ((c = f.read()) != -1) {
                if (c == '=') {
                    if ((c = f.read()) == '=')
                        System.out.print(".eq.");
                    else {
                        System.out.print("<-");
                        f.unread(c);
                    }
                } else {
                    System.out.print((char) c);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}