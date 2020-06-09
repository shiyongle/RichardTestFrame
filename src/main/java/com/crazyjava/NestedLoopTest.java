package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 23:40
 * @Description: 嵌套循环
 */
public class NestedLoopTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                System.out.println("i的值为:" + i + " j的值为:" + j);
            }
        }
    }
}
