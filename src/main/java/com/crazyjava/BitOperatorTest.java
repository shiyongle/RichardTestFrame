package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/8 21:17
 * @Description: 位运算符
 */
public class BitOperatorTest {
    public static void main(String[] args) {
        System.out.println(5 & 9);
        System.out.println(5 | 9);
        System.out.println(~ - 5);
        System.out.println(5 ^ 9);
        System.out.println(5 << 2);
        System.out.println(-5 << 2);
        System.out.println(-5 >> 2);
        System.out.println(-5 >>> 2);
    }
}
