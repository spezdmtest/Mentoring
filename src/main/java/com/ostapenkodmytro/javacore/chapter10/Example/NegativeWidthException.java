package com.ostapenkodmytro.javacore.chapter10.Example;

public class NegativeWidthException extends Exception {
    private int width;

    public NegativeWidthException(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}