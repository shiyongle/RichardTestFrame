package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/8 20:55
 * @Description: 算数运算符
 */
public class DivTest {
    public static void main(String[] args) {
        double a = 5.2;
        double b = 3.1;
        double div = a / b;
        System.out.println(div);

        //正无穷
        System.out.println("5除以0.0的结果是：" + 5 / 0.0);

        //报错
        System.out.println("-5除以0的结果是: " + -5 / 0);
    }
}
