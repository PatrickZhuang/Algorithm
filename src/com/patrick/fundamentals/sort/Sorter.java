package com.patrick.fundamentals.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 各种排序算法实现
 * Created by Patrick on 12/7/16.
 */
public class Sorter {

    /**
     * 冒泡排序
     *
     * @param list 无序list
     * @return 排序后的list
     */
    public static List<Integer> bubbleSort(List<Integer> list) {
        if (list != null && list.size() > 1) {
            int temp;
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = list.size() - 1; j > i; j--) {
                    if (list.get(j) < list.get(j - 1)) {
                        temp = list.get(j);
                        list.set(j, list.get(j - 1));
                        list.set(j - 1, temp);
                    }
                }
            }
        }
        return list;
    }


    public static void quickSort(List<Integer> list) {
        partition(list, 0, list.size() - 1);
    }

    private static void partition(List<Integer> list, int left, int right) {
        if (list != null && list.size() > 1 && left < right) {
            final int pivot = list.get(left);
            int start = left, end = right;
            int temp;

            while (start != end) {
                while (start < end && list.get(end) >= pivot) {
                    end--;
                }
                while (start < end && list.get(start) <= pivot) {
                    start++;
                }

                if (start < end) {
                    temp = list.get(start);
                    list.set(start, list.get(end));
                    list.set(end, temp);
                }
            }

            temp = list.get(end);
            list.set(end, pivot);
            list.set(left, temp);

            // 继续处理左边
            partition(list, left, end - 1);
            // 继续处理右边
            partition(list, end + 1, right);
        }
    }

}
