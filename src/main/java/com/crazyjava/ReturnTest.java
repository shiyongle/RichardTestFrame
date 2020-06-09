package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:00
 * @Description:
 */
public class ReturnTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++){
            System.out.println("i的值为："+ i);
            if (i == 1){
                return;
            }
            System.out.println("Return后边的语句");
        }
    }
}
