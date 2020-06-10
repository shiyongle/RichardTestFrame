package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 23:37
 * @Description:
 */
public class Varargs {
    /**
     * 定义形参个数可变的方法
     * @param a
     * @param books
     */
    public static void test(int a, String... books){
        for (String tmp:books){
            System.out.println(tmp);
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        test(5, "疯狂java讲义", "轻量级javaee应用");
    }
}
