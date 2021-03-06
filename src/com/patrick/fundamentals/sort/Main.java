package com.patrick.fundamentals.sort;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 测试用
 * Created by Patrick on 12/7/16.
 */
public class Main {
    public static void main(String[] args) {
        // 比较系统自带排序和冒泡排序的速度
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int capacity = 10000;
            List<Integer> list = new ArrayList<>(capacity);
            List<Integer> bubbleSortList = new ArrayList<>(capacity);
            List<Integer> quickSortList = new ArrayList<>(capacity);
            List<Integer> selectionSortList = new ArrayList<>(capacity);
            List<Integer> insertSortList = new ArrayList<>(capacity);
            List<Integer> shellSortList = new ArrayList<>(capacity);
            List<Integer> mergeSortList = new ArrayList<>(capacity);
            for (int j = 0; j < capacity; j++) {
                list.add(random.nextInt(5000));
            }

            bubbleSortList.addAll(list);
            quickSortList.addAll(list);
            selectionSortList.addAll(list);
            insertSortList.addAll(list);
            shellSortList.addAll(list);
            mergeSortList.addAll(list);

            System.out.println("\n第" + (i + 1) + "次比较");
            long start = System.currentTimeMillis();
            Collections.sort(list);
            System.out.println("Collections.sort用时 " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("排序后前10个数字分别是: " + list.subList(0, 10).stream().map(String::valueOf).collect(Collectors.joining(", ")));

            start = System.currentTimeMillis();
            Sorter.bubbleSort(bubbleSortList);
            System.out.println("bubble sort用时 " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("排序后前10个数字分别是: " + bubbleSortList.subList(0, 10).stream().map(String::valueOf).collect(Collectors.joining(", ")));

            start = System.currentTimeMillis();
            Sorter.quickSort(quickSortList);
            System.out.println("quick sort用时 " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("排序后前10个数字分别是: " + quickSortList.subList(0, 10).stream().map(String::valueOf).collect(Collectors.joining(", ")));

            start = System.currentTimeMillis();
            Sorter.selectionSort(selectionSortList);
            System.out.println("selection sort用时 " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("排序后前10个数字分别是: " + selectionSortList.subList(0, 10).stream().map(String::valueOf).collect(Collectors.joining(", ")));

            start = System.currentTimeMillis();
            Sorter.insertSort(insertSortList);
            System.out.println("insert sort用时 " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("排序后前10个数字分别是: " + insertSortList.subList(0, 10).stream().map(String::valueOf).collect(Collectors.joining(", ")));

            start = System.currentTimeMillis();
            Sorter.shellSort(shellSortList);
            System.out.println("shell sort用时 " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("排序后前10个数字分别是: " + shellSortList.subList(0, 10).stream().map(String::valueOf).collect(Collectors.joining(", ")));

            start = System.currentTimeMillis();
            Sorter.mergeSort(mergeSortList);
            System.out.println("merge sort用时 " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("排序后前10个数字分别是: " + mergeSortList.subList(0, 10).stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    public static Node reverse(Node node) {
        if (node.next == null) {
            return node;
        }
        Node prev = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return prev;
    }

    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
