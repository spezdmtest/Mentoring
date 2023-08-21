package com.ostapenkodmytro.javacore.chapter15;

interface MyArrayCreator<T> {
    T func(int n);
}

class MyClass6 {
    private int[] a;

    MyClass6(int value) {
        this.a = new int[]{value};
    }

    MyClass6() {
        a = null;
    }

    public int[] getA() {
        return a;
    }
}

public class ConstructorRefDemoArray {
    public static void main(String[] args) {
        MyArrayCreator<MyClass6[]> mcArrayCons = MyClass6[]::new;
        MyClass6[] array = mcArrayCons.func(3);
        array[0] = new MyClass6(1);
        array[1] = new MyClass6(2);
        array[2] = new MyClass6(3);

        System.out.print(array[0].getA()[0] + " ");
        System.out.print(array[1].getA()[0] + " ");
        System.out.println(array[2].getA()[0]);
    }
}
