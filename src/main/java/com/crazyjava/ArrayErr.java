package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:44
 * @Description:
 */
public class ArrayErr {
    public static void main(String[] args) {
        //Integer数组
        Integer[] ia = new Integer[5];

        //Integer数组赋给Number[]变量
        Number[] na = ia;

        //编译正常，运行错误，因为0.5不是Integer
        na[0] = 0.5;
    }
}
