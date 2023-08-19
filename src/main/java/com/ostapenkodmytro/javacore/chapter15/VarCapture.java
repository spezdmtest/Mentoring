package com.ostapenkodmytro.javacore.chapter15;

interface MyFunc {
    int func(int n);
}

public class VarCapture {
    public static void main(String[] args) {
        int num = 10;

        MyFunc myLambda = (n) -> num + n;

        System.out.println(myLambda.func(0));
    }
}