package com.ostapenkodmytro.javacore;

public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        methodA();
    }

    static public void methodA(){
        methodB();
    }

    static public void methodB(){
        methodA();
    }
}
