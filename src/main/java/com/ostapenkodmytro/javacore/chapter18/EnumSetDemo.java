package com.ostapenkodmytro.javacore.chapter18;

import java.util.EnumSet;

enum DayOfWeek{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
public class EnumSetDemo {
    public static void main(String[] args) {
        EnumSet<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        weekend.add(DayOfWeek.FRIDAY);
        System.out.println("Weekend days: " + weekend);

        EnumSet<DayOfWeek> allDays = EnumSet.allOf(DayOfWeek.class);
        System.out.println("Create an EnumSet of all days of the week: " + allDays );

        EnumSet<DayOfWeek> emptySet = EnumSet.noneOf(DayOfWeek.class);
        System.out.println("Create an empty EnumSet: " + emptySet);

        EnumSet<DayOfWeek> workdays = EnumSet.range(DayOfWeek.MONDAY, DayOfWeek.FRIDAY);
        System.out.println("Create an EnumSet from a range of elements: " + workdays);

        EnumSet<DayOfWeek> nonWorkdays = EnumSet.complementOf(workdays);
        System.out.println("Create a complement of an EnumSet: " + workdays);

        System.out.println("Is Thursday a workday? " + workdays.contains(DayOfWeek.THURSDAY));

    }

}
