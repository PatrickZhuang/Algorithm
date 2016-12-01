package com.patrick.fundamentals.recursion;

/**
 * 递归求阶乘
 * Created by Patrick on 12/1/16.
 */
public class Factorial {
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            int subSolution = factorial(n - 1);
            return subSolution * n;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(factorial(i));
        }
    }
}
