package com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.website;

import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.Developer;
import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.ProjectManager;
import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.ProjectTeamFactory;
import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}
