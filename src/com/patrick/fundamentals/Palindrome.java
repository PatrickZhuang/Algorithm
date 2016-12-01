package com.patrick.fundamentals;

import java.util.*;

/**
 * Created by Patrick on 11/21/16.
 */
public class Palindrome {
    public static void main(String[] args) {
        long[] palindrome = findAllPalindrome(3);
        System.out.println("\nresult\nfirst:" + palindrome[0] + ",second:" + palindrome[1] + ",value:" + palindrome[2]);
    }

    public static long[] findAllPalindrome(int digit) {
        long start = System.currentTimeMillis();

        long[] result = new long[3];
        long max = (long) Math.pow(10, digit);
        long min = (long) Math.pow(10, digit - 1);
        List<Map<String, Long>> list = new LinkedList<>();
        Map<String, Long> map;
        for (long i = max - 1; i >= min; i--) {
            for (long j = max - 1; j >= min; j--) {
                String value = String.valueOf(i * j);
                if (value.equals(new StringBuilder(value).reverse().toString())) {
                    map = new HashMap<>();
                    map.put("first", i);
                    map.put("second", j);
                    map.put("value", i * j);
                    list.add(map);
                    System.out.println("first:" + i + ",second:" + j + ",value:" + value);
                }
            }
        }

        Collections.sort(list, new Comparator<Map<String, Long>>() {
            @Override
            public int compare(Map<String, Long> o1, Map<String, Long> o2) {
                return (int) (o2.get("value") - o1.get("value"));
            }
        });

        if (list.size() != 0) {
            result[0] = list.get(0).get("first");
            result[1] = list.get(0).get("second");
            result[2] = list.get(0).get("value");
        }

        System.out.println("duration:" + (System.currentTimeMillis() - start) + "ms");
        return result;
    }

}
