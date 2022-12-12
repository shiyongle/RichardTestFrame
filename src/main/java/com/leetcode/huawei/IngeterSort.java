package com.leetcode.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 输入整型数字和排序标识，对其元素按照升序或降序进行排序
 */
public class IngeterSort {
    public void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag) {
        // 按升序
        if (iSortFlag == 0) {
            Arrays.sort(pIntegerArray, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        }
        // 按降序
        else {
            Arrays.sort(pIntegerArray, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
    }

    public void output(Integer[] array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IngeterSort solution = new IngeterSort();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            int flag = in.nextInt();
            solution.sortIntegerArray(array, flag);
            solution.output(array);
        }

    }
}
