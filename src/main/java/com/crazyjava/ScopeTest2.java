package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/11 23:14
 * @Description:
 */
public class ScopeTest2 {
    public static void main(String[] args) {
        //定义一个方法的局部变量作为循环变量
        int a;
        for (int i = 0; i < 10; i++){
            System.out.println("Hello");
        }
    }
}
