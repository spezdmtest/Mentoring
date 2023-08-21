package com.ostapenkodmytro.javacore.chapter15;

interface MyFunc5<T> {
    MyClass3<T> func(T n);
}

class MyClass3<T> {
    private T val;

    public MyClass3(T v) {
        val = v;
    }

    public MyClass3() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        MyFunc5<Integer> myClassCons = MyClass3<Integer>::new;
        MyClass3<Integer> mc = myClassCons.func(100);

        System.out.println("Значение val в объекте mc равно " + mc.getVal());
    }
}