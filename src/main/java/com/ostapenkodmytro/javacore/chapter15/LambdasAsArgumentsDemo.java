package com.ostapenkodmytro.javacore.chapter15;

interface StringFuncV2 {
    String func(String m);
}

public class LambdasAsArgumentsDemo {
    static String stringOp(StringFuncV2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        System.out.println("Это исходная строка: " + inStr);
        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("Это строка в верхнем регистре: " + outStr);

        outStr = stringOp((str) -> {
            StringBuilder result = new StringBuilder(" ");
            // int i;

            for (int i = 0; i < str.length(); i++)
                if (str.charAt(i) != ' ')
                    result.append(str.charAt(i));
            return result.toString();
        }, inStr);
        System.out.println("Это строка с удаленным пробелами: " + outStr);


        StringFuncV2 reverse = (str) -> {
            StringBuilder result = new StringBuilder(" ");
            int i;
            for (i = str.length() - 1; i >= 0; i--)
                result.append(str.charAt(i));
            return result.toString();
        };

        System.out.println("Это обращенная строка: " +
                stringOp(reverse, inStr));
    }
}
