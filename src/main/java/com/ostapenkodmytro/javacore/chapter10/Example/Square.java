package com.ostapenkodmytro.javacore.chapter10.Example;

public class Square {
    private int width;

    public Square(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int calculateArea(int width) throws NegativeWidthException {
        if (width >= 0) {
            return width * width;
        } else {
            throw new NegativeWidthException(width);
        }
    }
}