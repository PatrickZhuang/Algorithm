package com.patrick.fundamentals.recursion;

import java.util.Arrays;

/**
 * reverse string
 * Created by Patrick on 12/1/16.
 */
public class Reverse {
    public static String revers(String word) {
        if (word == null || word.equals("")) {
            return word;
        } else {
            String substring = word.substring(1);
            return revers(substring) + word.substring(0, 1);
        }
    }

    public static char[] reverseIteration(char[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            array[start] = (char) (array[start] ^ array[end]);
            array[end] = (char) (array[start] ^ array[end]);
            array[start] = (char) (array[start] ^ array[end]);
            start++;
            end--;
        }
        return array;
    }

    public static char[] reversRecursive(char[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        return reversRecursive(array, 0, array.length - 1);
    }

    private static char[] reversRecursive(char[] array, int start, int end) {
        if (start < end) {
            array[start] = (char) (array[start] ^ array[end]);
            array[end] = (char) (array[start] ^ array[end]);
            array[start] = (char) (array[start] ^ array[end]);
            start++;
            end--;
            reversRecursive(array, start, end);
        }
        return array;
    }

    public static void main(String[] args) {
        String word = "Hello World!";
        System.out.println(word);
        System.out.println(revers(word));


        char[] chars = {'a', 'b', 'c', 'd'};
        System.out.println("original array is " + Arrays.toString(chars));
        reverseIteration(chars);
        System.out.println("reversed by iteration  " + Arrays.toString(chars));
        reversRecursive(chars);
        System.out.println("reversed by recursion  " + Arrays.toString(chars));
    }

}
