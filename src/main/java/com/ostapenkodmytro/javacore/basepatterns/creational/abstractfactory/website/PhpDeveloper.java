package com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.website;

import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer writes php code");
    }
}
