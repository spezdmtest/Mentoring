package com.ostapenkodmytro.javacore.chapter20;

public class PrintfDemo {
    public static void main(String[] args) {
        System.out.println("Ниже приведены некоторые " +
                "числовые значения в разных форматах. \n");
        System.out.print("Разные числоые форматы: ");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);

        System.out.println();
        System.out.printf("Формат чисел с плавающей точкой " +
                " по умолчанию: %f\n", 1234567.123);
        System.out.printf("Формат чисел с плавающей точкой " +
                " по умолчанию: %,f\n", 1234567.123);
        System.out.printf("Формат отрицательных чисел с " +
                "плавающей точкой по умолчанию: %,f\n", -1234567.123);
        System.out.printf("Другой Формат отрицательных чисел с " +
                "плавающей точкой: %,(f\n", -1234567.123);

        System.out.println();

        System.out.print("Выравнивание положительных и " +
                "отрицательных числовых значений: \n");
        System.out.printf("% ,.2f\n", 1234567.123);
        System.out.printf("% ,.2f\n", -
                1234567.123);
    }
}
