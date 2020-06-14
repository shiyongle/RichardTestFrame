package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/14 23:53
 * @Description:
 */
public class HideTest {
    public static void main(String[] args) {
        Derived d = new Derived();
        System.out.println(((Parent) d).tag);
    }
}
