package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/7 23:29
 * @Description: 疯狂java讲义-自动类型转换
 */
public class AutoConversion {
    public static void main(String[] args) {
        int a = 6;
        float f = a;
        System.out.println(f);

        byte b = 9;
//        char c = b;       byte不能自动转换为char
        double d = b;
        System.out.println(d);
    }
}
