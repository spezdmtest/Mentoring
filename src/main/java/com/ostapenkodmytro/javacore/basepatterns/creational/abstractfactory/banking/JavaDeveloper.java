package com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.banking;

import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes java code....");
    }
}
