package com.ostapenkodmytro.javacore.basepatterns.bihavioral.state;

public class Reading implements Activity {
    @Override
    public void justDoIt() {
        System.out.println("Reading book");
    }
}
