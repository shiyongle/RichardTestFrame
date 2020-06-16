package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/16 21:29
 * @Description:
 */
public class StaticInitTest {
    static {
        int a = 6;
    }

    static int a = 9;

    public static void main(String[] args) {
        System.out.println(StaticInitTest.a);
    }
}
