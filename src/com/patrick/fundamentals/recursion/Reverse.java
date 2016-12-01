package com.patrick.fundamentals.recursion;

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

    public static void main(String[] args) {
        String word = "Hello World!";
        System.out.println(word);
        System.out.println(revers(word));
    }
}
