package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/8 20:59
 * @Description: 求余运算
 */
public class ModTest {
    public static void main(String[] args) {
        double a = 5.2;
        double b = 3.1;
        double mod = a % b;
        System.out.println(mod);
        System.out.println("5对0.0求余的结果是：" + 5 % 0.0);       //非数
        System.out.println("-5对0求余的结果是：" + -5 % 0.0);       //非数
        System.out.println("0对5.0求余的结果是: " + 0 % 5.0);      //0.0
        System.out.println("0对0.0求余的结果是：" + 0 % 0.0);       //NaN
        System.out.println("-5对0求余的结果是：" + -5 % 0);
    }
}
