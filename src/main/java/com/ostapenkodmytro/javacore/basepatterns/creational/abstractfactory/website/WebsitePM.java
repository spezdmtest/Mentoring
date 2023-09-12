package com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.website;

import com.ostapenkodmytro.javacore.basepatterns.creational.abstractfactory.ProjectManager;

public class WebsitePM implements ProjectManager {
    @Override
    public void managerProject() {
        System.out.println("Website PM manages website project....");
    }
}
