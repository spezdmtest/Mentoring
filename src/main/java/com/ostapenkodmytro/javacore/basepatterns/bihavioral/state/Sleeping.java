package com.ostapenkodmytro.javacore.basepatterns.bihavioral.state;

public class Sleeping implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Sleeping");
    }
}
