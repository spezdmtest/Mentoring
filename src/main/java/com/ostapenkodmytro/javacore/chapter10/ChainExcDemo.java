package com.ostapenkodmytro.javacore.chapter10;

public class ChainExcDemo {
    static void demoproc() {
        NullPointerException e = new NullPointerException("верхний уровень");
        e.initCause(new ArithmeticException("причина"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Перехвачено исключение: " + e);
            System.out.println("Перехвачено: " + e.getCause());
        }
    }
}