package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/14 23:48
 * @Description:
 */
public class BaseClass {
    public int a = 5;
    public int book = 6;

    public void base(){
        System.out.println("父类的普通方法");
    }

    public void test(){
        System.out.println("父类的被覆盖的方法");
    }
}
