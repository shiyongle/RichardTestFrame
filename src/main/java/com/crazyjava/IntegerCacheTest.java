package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/29 21:35
 * @Description:
 */
public class IntegerCacheTest {
    public static void main(String[] args) {
        Integer in1 = new Integer(6);
        Integer in2 = Integer.valueOf(6);
        Integer in3 = Integer.valueOf(6);
        System.out.println(in1 == in2);
        System.out.println(in2 == in3);
        Integer in4 = Integer.valueOf(200);
        Integer in5 = Integer.valueOf(200);
        System.out.println(in4 == in5);
    }
}
