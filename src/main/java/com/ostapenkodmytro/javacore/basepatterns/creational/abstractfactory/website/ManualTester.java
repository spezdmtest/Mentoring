package com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.website;

import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Manual tester tests website....");
    }
}
