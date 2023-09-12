package com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.banking;

import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void managerProject() {
        System.out.println("Banking PM manages banking projects....");
    }
}
