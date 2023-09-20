package com.ostapenkodmytro.javacore.basepatterns.structural.bridge;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java Developer writes Java code");
    }
}
