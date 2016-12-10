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

    /**
     * 快速排序
     *
     * @param list
     */
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

    /**
     * 选择排序
     * 选一个基准,基准后面的数依次和基准数比较,记录下最小的数的index,最后交换基准index和最小数index;和冒泡排序循环一样的次数,比冒泡效率稍高,也是O(n2),只是选择排序只记录最小数index,最后交换1次,冒泡排序一直交换位置到最后
     *
     * @param list
     */
    public static void selectionSort(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i; // temp index保存最小的index
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }
}
