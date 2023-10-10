package com.ostapenkodmytro.javacore.basepatterns.bihavioral.template;

public class WebsiteRunner {
    public static void main(String[] args) {
        WebsiteTemplate welcomePage = new WelcomePage();
        WebsiteTemplate newsPage = new NewPage();

        welcomePage.showPage();

        System.out.println("\n=====================================================================================\n");

        newsPage.showPage();
    }
}
