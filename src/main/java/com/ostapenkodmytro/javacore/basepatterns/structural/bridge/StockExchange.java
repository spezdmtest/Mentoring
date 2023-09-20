package com.ostapenkodmytro.javacore.basepatterns.structural.bridge;

public class StockExchange extends Program {
    public StockExchange(Developer developer) {
        super(developer);
    }
    @Override
    public void developProgram() {
        System.out.println("Stock Exchange development in progress...");
        developer.writeCode();
    }
}
