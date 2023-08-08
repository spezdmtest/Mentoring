package com.ostapenkodmytro.javacore.chapter18.Example1;

import java.util.*;

/**
 * Задание 1
 * Дан массив целых чисел. Необходимо реализовать метод,
 * который возвращает индексы массива,
 * значения которых в сумме дают число переданное в массив.
 * Предполагается, что массив содержит только уникальные числа
 * и всегда имеет искомые числа.
 * Один и тот же элемент не может быть использован дважды.
 * <p>
 * array = [3, 8, 15, 17], Number = 23
 * result = [1,2]
 * <p>
 * Т.е. индексы 1 и 2 (значение 8 и 15) в сумме дают искомое число 23
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {3, 8, 15, 17};
        System.out.println(Arrays.toString(twoSum(array, 23)));
    }

    private static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
            int diff = target - array[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
        }
//        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
//        for (Map.Entry<Integer, Integer> out : set) {
//            System.out.print(Arrays.toString(new Integer[]{out.getKey()}));
//        }
        return new int[0];
    }
}