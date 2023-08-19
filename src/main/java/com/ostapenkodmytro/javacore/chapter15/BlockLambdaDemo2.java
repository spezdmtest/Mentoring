package com.ostapenkodmytro.javacore.chapter15;

interface StringFunc {
    String func(String n);
}

public class BlockLambdaDemo2 {
    public static void main(String[] args) {
        StringFunc reverse = (str) -> {
            StringBuilder result = new StringBuilder();
            int i;

            for (i = str.length() - 1; i >= 0; i--)
                result.append(str.charAt(i));
            return result.toString();
        };
        System.out.println("Лямбда обращается на " +
                reverse.func("Лямбда"));
        System.out.println("Лямбда обращается на " +
                reverse.func("Выражение"));
    }
}