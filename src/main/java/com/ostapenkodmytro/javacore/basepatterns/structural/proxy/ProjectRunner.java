package com.ostapenkodmytro.javacore.basepatterns.structural.proxy;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new ProxyProject("https://www.github.com/spezdmtest/realProject");
        project.run();
    }
}
