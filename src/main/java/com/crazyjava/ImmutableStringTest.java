package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/22 0:14
 * @Description:
 */
public class ImmutableStringTest {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}
