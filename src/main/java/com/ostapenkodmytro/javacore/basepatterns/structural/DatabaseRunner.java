package com.ostapenkodmytro.javacore.basepatterns.structural;

public class DatabaseRunner {
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();
        database.insert();
        database.update();
        database.select();
        database.remove();
    }
}
