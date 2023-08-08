package com.ostapenkodmytro.javacore.chapter18.Example2;

import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.Set;

/**
 * Задание 2
 * Дан массив целых чисел.
 * Необходимо реализовать метод, которые определяет, содержит ли данный массив дубликаты
 * <p>
 * Пример:
 * Array: [4,5,6,6,8]
 * Result: true
 * Число 6 повторяется 2 раза
 * <p>
 * Array: [4,5,6,7,8]
 * Result: false
 * Дубликатов нет
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 6, 8};
        boolean result = containDuplicate(array);
        System.out.println("Массив содержит дубликаты: " + result);
    }

    private static boolean containDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
