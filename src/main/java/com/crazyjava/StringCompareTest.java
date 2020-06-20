package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/20 17:48
 * Description:
 */
public class StringCompareTest {
    public static void main(String[] args) {
        String s1 = "疯狂java";
        String s2 = "疯狂";
        String s3 = "java";
        String s4 = "疯狂" + "java";
        String s5 = "疯" + "狂" + "java";
        String s6 = s2 + s3;
        String s7 = new String("疯狂java对象");
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s7);
    }
}
