package com.ostapenkodmytro.javacore.basepatterns.creational.builder;

public class BuildWebsiteRunner {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new EnterpriseWebsiteBuilder());
        Website website = director.builderWebsite();
        System.out.println(website);

    }
}
