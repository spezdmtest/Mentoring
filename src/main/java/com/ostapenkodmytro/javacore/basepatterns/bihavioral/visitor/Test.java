package com.ostapenkodmytro.javacore.basepatterns.bihavioral.visitor;

public class Test implements ProjectElement {
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}
