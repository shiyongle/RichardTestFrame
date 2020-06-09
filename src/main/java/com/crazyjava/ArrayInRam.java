package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:11
 * @Description:
 */
public class ArrayInRam {
    public static void main(String[] args) {
        //定义并初始化数组，使用静态初始化
        int[] a = {5, 7, 20};

        //定义并初始化数组，使用动态初始化
        int[] b = new int[4];

        System.out.println("b数组的长度为:" + b.length);

        //循环输出a数组的元素
        for (int i =0, len = a.length; i < len; i++){
            System.out.println(a[i]);
        }

        //循环输出b数组的元素
        for (int i =0, len = b.length; i < len; i++){
            System.out.println(b[i]);
        }

        b = a;

        System.out.println("b数组的长度为：" + b.length);
    }
}
