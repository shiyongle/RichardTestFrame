package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 23:47
 * @Description: 结束循环
 */
public class BreakTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++){
            System.out.println("i的值为:" + i);
            if (i == 2){
                break;
            }
        }
    }
}
