package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/8 9:56
 * Description: 类型强制转换
 */
public class NarrowConversion {
    public static void main(String[] args) {
        int iValue = 233;

        //强制将int转为byte,典型的溢出
        byte bValue = (byte) iValue;

        System.out.println(bValue);

        double dValue = 3.98;

        //强制将double转为int
        int tol = (int) dValue;
        System.out.println(tol);

    }
}
