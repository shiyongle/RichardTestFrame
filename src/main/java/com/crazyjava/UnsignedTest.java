package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/20 17:28
 * Description:
 */
public class UnsignedTest {
    public static void main(String[] args) {
        byte b = -3;
        System.out.println("byte类型-3对应的无符号整数：" + Byte.toUnsignedInt(b));

        Integer val = Integer.parseUnsignedInt("ab", 16);
        System.out.println("指定为16进制转化：" + val);
        System.out.println("将-12转化为无符号int型，再转化为16进制的字符串：" + Integer.toUnsignedString(-12, 16));
        System.out.println("将两个数转换为无符号整数后相除 ： " + Integer.divideUnsigned(-2, 3));
        System.out.println("将两个数转换为无符号整数后相除后求余 ： " + Integer.remainderUnsigned(-2, 7));
    }
}
