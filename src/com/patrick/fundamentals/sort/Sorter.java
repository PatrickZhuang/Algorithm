package com.patrick.fundamentals.sort;

import com.sun.istack.internal.NotNull;

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

    /**
     * 直接插入排序,序列分两组,一个是排序好的,一个是待排序的,每次再待排序序列中取第一个数去和排序好的依次比较,找到位置插入
     *
     * @param list
     */
    public static void insertSort(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        // 遍历无序数组,取第一个数字
        for (int i = 1; i < list.size(); i++) {
            // 遍历有序数组
            int temp = list.get(i);
            int j = i - 1;
            for (; j >= 0 && temp < list.get(j); j--) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, temp);
        }
    }

    /**
     * 希尔排序,插入排序增强版,递减步长
     *
     * @param list
     */
    public static void shellSort(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        int step = list.size() / 2;
        while (step >= 1) {
            for (int i = step; i < list.size(); i++) {
                int temp = list.get(i);
                int j = i - step;
                for (; j >= 0 && temp < list.get(j); j -= step) {
                    list.set(j + step, list.get(j));
                }
                list.set(j + step, temp);
            }
            step /= 2;
        }
    }

    public static void mergeSort(List<Integer> unsortedList) {
        Integer[] temp = new Integer[unsortedList.size()];
        mergeSort(unsortedList, temp, 0, unsortedList.size() - 1);
    }

    private static void mergeSort(List<Integer> unsortedList, Integer[] tempList, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(unsortedList, tempList, left, mid);
            mergeSort(unsortedList, tempList, mid + 1, right);
            merge(unsortedList, left, mid, right, tempList);
        }
    }

    /**
     * 连接两个有序数组生成有序数组
     *
     * @param list
     */
    private static void merge(@NotNull List<Integer> list, int left, int mid, int right, @NotNull Integer[] temp) {
        int leftStart = left;
        int rightStart = mid + 1;
        int tempIndex = left;
        while (leftStart <= mid && rightStart <= right) {
            try {
                if (list.get(leftStart) < list.get(rightStart)) {
                    temp[tempIndex++] = list.get(leftStart++);
                } else {
                    temp[tempIndex++] = list.get(rightStart++);
                }
            } catch (Exception e) {
                System.out.println("left start : " + leftStart);
                System.out.println("right start : " + rightStart);
                System.out.println("temp index : " + tempIndex);
            }

        }

        while (leftStart <= mid) {
            temp[tempIndex++] = list.get(leftStart++);
        }

        while (rightStart <= right) {
            temp[tempIndex++] = list.get(rightStart++);
        }

        for (int index = left; index <= right; index++) {
            list.set(index, temp[index]);
        }
    }
}
