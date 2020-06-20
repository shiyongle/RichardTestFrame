package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/20 17:43
 * Description:
 */
public class EqualTest {
    public static void main(String[] args) {
        int it = 65;
        float f1 = 65.0f;
        System.out.println("65和65.0f是否相等：" + (it == f1));

        char ch = 'A';
        System.out.println("65和‘a’是否相等:" + (it == ch));


        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("str1和str2是否相等：" + (str1 == str2));
        System.out.println("str1是否equals str2：" + (str1.equals(str2)));
    }
}
