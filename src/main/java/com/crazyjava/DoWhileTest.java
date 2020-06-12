package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 16:49
 * Description:
 */
public class DoWhileTest {
    public static void main(String[] args) {
        int count = 1;
        do {
            System.out.println(count);
            count++;
        }while (count < 10);
        {
            System.out.println("循环结束");
        }
    }
}
