package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/22 0:05
 * @Description:
 */
public class StringJoinTest {
    public static void main(String[] args) {
        String s1 = "疯狂java";
        String s2 = "疯狂" + "java";
        System.out.println(s1 == s2);

        String str1 = "疯狂";
        String str2 = "java";
        String str3 = str1 + str2;
        System.out.println(s1 == str3);
    }
}
