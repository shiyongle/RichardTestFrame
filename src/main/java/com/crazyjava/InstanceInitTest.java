package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/16 21:12
 * @Description:
 */
public class InstanceInitTest {
    {
        int a = 6;
    }

    int a = 9;

    public static void main(String[] args) {
        System.out.println(new InstanceInitTest().a);
    }
}
