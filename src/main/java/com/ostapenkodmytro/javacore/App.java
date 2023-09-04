package com.ostapenkodmytro.javacore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

    }
}

/**
 * By following these guidelines, you ensure that instances of the Person class are immutable, and once created,
 * their state cannot be modified. This allows for safer and more predictable handling of objects in concurrent environments
 * and ensures the integrity of the data stored within the Person objects.
 */

final class PersonImmutableClass {
    private final String name;
    private final Calendar calendar;
    private final Collection<PersonImmutableClass> background;

    public PersonImmutableClass(String name, Calendar calendar, Collection<PersonImmutableClass> background) {
        this.name = name;
        this.calendar =(Calendar) calendar.clone();
        this.background = Collections.unmodifiableCollection(new ArrayList<>(background));
    }

    public String getName() {
        return name;
    }

    public Calendar getCalendar() {
        // Return a new copy of the Calendar to prevent modification of the original object
        return (Calendar) calendar.clone();
    }

    public Collection<PersonImmutableClass> getBackground() {
        // Return an unmodifiable view of the background Collection to prevent modification
        return Collections.unmodifiableCollection(background);
    }
}