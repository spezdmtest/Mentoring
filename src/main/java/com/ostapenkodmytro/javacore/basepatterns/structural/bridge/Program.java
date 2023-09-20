package com.ostapenkodmytro.javacore.basepatterns.structural.bridge;

public abstract class Program {
    protected Developer developer;

    protected Program(Developer developer) {
        this.developer = developer;
    }

    public abstract void developProgram();
}
