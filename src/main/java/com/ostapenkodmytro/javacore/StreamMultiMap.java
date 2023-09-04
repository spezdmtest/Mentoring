package com.ostapenkodmytro.javacore;

import java.util.List;

public class StreamMultiMap {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry");
        words.stream()
                .mapMulti((word, consumer) -> {
                    for (char c : word.toCharArray()) {
                        consumer.accept(Character.toUpperCase(c));
                    }
                }).forEach(c -> System.out.print(c + " "));
    }
}
