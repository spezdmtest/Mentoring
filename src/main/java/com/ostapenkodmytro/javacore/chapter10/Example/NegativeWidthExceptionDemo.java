package com.ostapenkodmytro.javacore.chapter10.Example;

public class NegativeWidthExceptionDemo {
    public static void main(String[] args) throws NegativeWidthException {
        Square square = new Square(-1);

        System.out.println("Square width: " + square.getWidth());

        System.out.print("Calculating area...\n");
        System.out.println("Area: " + square.calculateArea(square.getWidth()));
    }
}