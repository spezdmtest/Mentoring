package com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.banking;

import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.Developer;
import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.ProjectManager;
import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.ProjectTeamFactory;
import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
