package com.crazyjava;

import java.util.Arrays;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:36
 * @Description:
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] a1 = new int[]{6,7,8,9,10};
        System.out.println("a数组和a1数组是否相等:" + Arrays.equals(a, a1));

        //copy数组，新长度
        int[] b = Arrays.copyOf(a, 6);
        System.out.println("a数组和b数组是否相等：" + Arrays.equals(a, b));
        System.out.println("b数组的元素为：" + Arrays.toString(b));

        //将b数组的第二个元素到第四个元素复制为1，不包括4
        Arrays.fill(b, 2, 4, 1);
        System.out.println("b数组的元素为：" + Arrays.toString(b));

        //排序
        Arrays.sort(b);
        System.out.println("b数组的元素为：" + Arrays.toString(b));
    }
}
