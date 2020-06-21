package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/21 23:53
 * @Description:
 */
public class FinalLocalVariableTest {
    public void test(final int a){
//        a = 5;        不能final修饰的形参赋值
    }

    public static void main(String[] args) {
        //局部变量只可赋值一次
        final String str = "hello";
        final double d;
        d = 5.6;
        System.out.println(str);
        System.out.println(d);
    }
}
