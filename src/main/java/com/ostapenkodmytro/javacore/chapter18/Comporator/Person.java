package com.ostapenkodmytro.javacore.chapter18.Comporator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static final Comparator<Person> AGE_COMPARATOR = Comparator.comparingInt(Person::getAge);
    public static final Comparator<Person> NAME_COMPARATOR = Comparator.comparing(Person::getName);

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 30));
        persons.add(new Person("Charlie", 20));

        persons.sort(Person.AGE_COMPARATOR);
        System.out.println(persons);

        persons.sort(Person.NAME_COMPARATOR);
        System.out.println(persons);
    }
}
