package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/17 21:01
 * @Description:
 */
public class Primitive2String {
    public static void main(String[] args) {
        String intStr = "123";

        //把一个特定字符串转换成int变量
        int it1 = Integer.parseInt(intStr);
        int it2 = Integer.valueOf(intStr);
        System.out.println(it2);

        String ftrStr = "4.56";
        //把一个特定的字符串转化成float变量
        float ft1 = Float.parseFloat(ftrStr);
        float ft2 = Float.valueOf(ftrStr);
        System.out.println(ft2);

        //把一个float变量转化为String变量
        String ftStr = String.valueOf(2.345f);
        System.out.println(ftStr);

        //把一个double变量转化为String变量
        String dbStr = String.valueOf(3.334);
        System.out.println(dbStr);

        //把一个boolean变量转换成String变量
        String boolStr = String.valueOf(true);
        System.out.println(boolStr);
    }
}
