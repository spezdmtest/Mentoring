package com.ostapenkodmytro.javacore.basepatterns.bihavioral.template;

public class NewPage extends WebsiteTemplate {
    @Override
    public void showPageContent() {
        System.out.println("News");
    }
}
