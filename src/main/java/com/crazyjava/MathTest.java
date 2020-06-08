package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/8 21:10
 * @Description: Math常用方法：开方，乘方等
 */
public class MathTest {
    public static void main(String[] args) {
        double a = 3.2;
        //求a的五次方
        double b = Math.pow(a , 5);
        System.out.println(b);

        //求a的平方根
        double c = Math.sqrt(a);
        System.out.println(c);

        //随机数
        double d = Math.random();
        System.out.println(d);

        double e = Math.sin(a);
        System.out.println(e);
    }
}
