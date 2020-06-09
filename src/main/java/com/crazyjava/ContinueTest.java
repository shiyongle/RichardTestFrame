package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 23:54
 * @Description:
 */
public class ContinueTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++){
            System.out.println("i的值是:" + i);
            if (i == 1){
                continue;
            }
            System.out.println("Continue后输出的语句");
        }
    }
}
