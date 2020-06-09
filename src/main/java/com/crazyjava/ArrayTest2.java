package com.crazyjava;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:43
 * @Description:
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, -4, 25, 16, 30, 18};
        //并发排序
        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[]{3, -4, 25, 16, 30, 18};
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            //left代表新数组中前一个索引处的元素，right代表原数组中当前索引处的元素
            //新数组的第一个元素等于原数组的第一个元素
            @Override
            public int applyAsInt(int left, int right) {
                return left * right;
            }
        });
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[5];
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * 5;
            }
        });
        System.out.println(Arrays.toString(arr3));
    }
}
