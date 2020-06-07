package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/7 23:32
 * @Description: 字符串拼接的类型自动转换
 */
public class PrimitiveAndString {
    public static void main(String[] args) {
//        String str1 = 5;  5是整数，不能赋值给字符串
        //基本类型的值与字符串相连接，基本类型的值自动转换为字符串
        String str2 = 3.5f + "";
        System.out.println(str2);

        System.out.println(3 + 4 + "Hello!");

        //将3和4当做字符串处理
        System.out.println("Hello!" + 3 + 4);
    }
}
