package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 16:59
 * Description:
 */
public class ForErrorTest {
    public static void main(String[] args) {
        for (int count = 0; count < 10; count ++){
            System.out.println(count);
            count *= 0.1;
        }
        System.out.println("循环结束");
    }
}
