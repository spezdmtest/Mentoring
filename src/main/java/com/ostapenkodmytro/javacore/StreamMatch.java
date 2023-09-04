package com.ostapenkodmytro.javacore;

import java.util.List;

public class StreamMatch {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(2, 4, 6, 8, 10);

        boolean allEven = numbers.stream().allMatch(num -> num % 2 == 0);
        System.out.println("Are all numbers even? " + allEven); // true

        boolean anyOdd = numbers.stream().anyMatch(num -> num % 2 != 0);
        System.out.println("Are there any odd numbers? " + anyOdd); // false

        boolean noneNegative = numbers.stream().noneMatch(num -> num < 0);
        System.out.println("Are there no negative numbers? " + noneNegative); // true


        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
        boolean allStartWithA = words.stream().allMatch(word -> word.startsWith("a"));
        boolean anyEndWithY = words.stream().anyMatch(word -> word.endsWith("y"));
        boolean noneContainX = words.stream().noneMatch(word -> word.contains("x"));

        System.out.println("All start with 'a'? " + allStartWithA);  // Output: false
        System.out.println("Any end with 'y'? " + anyEndWithY);  // Output: true
        System.out.println("None contain 'x'? " + noneContainX);  // Output: true
    }
}
