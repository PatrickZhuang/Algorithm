package com.patrick.fundamentals;

/**
 * 二分查找
 * Created by Patrick on 2016/4/6.
 */
public class BinarySearch {

    public static int index(int[] array, int key) {
        // array 必须是有序的
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < array[mid]) start = end = mid - 1;
            else if (key > array[mid]) start = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        // 白名单
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] keys = {0, 5, 9, 10, 20, 30, 40};
        for (int key : keys) {
            // 输出白名单以外的数字
            if (index(array, key) < 0) {
                System.out.println(key + "\t");
            }
        }
    }
}
