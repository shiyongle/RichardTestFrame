package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 16:53
 * Description: ForTest
 */
public class ForTest2 {
    public static void main(String[] args) {
        for (int b = 0, s = 0, p = 0; b < 10 && s < 4 && p <4; p++){
            System.out.println(b++);
            System.out.println(++s + p);
        }
    }
}
