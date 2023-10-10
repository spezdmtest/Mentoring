package com.ostapenkodmytro.javacore.basepatterns.bihavioral.strategy;

public class Training implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}
