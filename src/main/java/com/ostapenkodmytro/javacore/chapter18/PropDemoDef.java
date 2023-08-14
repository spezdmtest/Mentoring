package com.ostapenkodmytro.javacore.chapter18;

import java.util.Properties;
import java.util.Set;

public class PropDemoDef {
    public static void main(String[] args) {
        Properties defList = new Properties();
        defList.put("Флорида","Телесси");
        defList.put("Висконсин","Мэдисон");
        Properties capitals = new Properties(defList);
        capitals.put("Илинойс","Спрингфилд");
        capitals.put("Миссури","Джефферсон-Сити");
        capitals.put("Вашингтон","Олимпия");
        capitals.put("Калифорния","Сакраменто");
        capitals.put("Индиана","Индианаполис");

        Set<?> states = capitals.keySet();
        for(Object name : states)
            System.out.println("Столица штата: " + name + " - " + capitals.getProperty((String)name) + ".");
        System.out.println();

        String str = capitals.getProperty("Флорида");
        System.out.println("Столица Флориды - " + str + ".");
    }
}