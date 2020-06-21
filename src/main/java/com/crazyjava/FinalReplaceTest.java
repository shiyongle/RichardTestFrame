package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/22 0:01
 * @Description:
 */
public class FinalReplaceTest {
    public static void main(String[] args) {
        final int a = 5 + 2;
        final double b = 1.2 / 3;
        final String str = "疯狂" + "讲义";
        final String bool = "疯狂java讲义" + 99.0;

        final String book = "疯狂java讲义：" + String.valueOf(99.0);
        System.out.println(bool == "疯狂java讲义：99.0");
        System.out.println(book == "疯狂java讲义：99.0");
    }
}
