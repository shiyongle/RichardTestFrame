package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 17:13
 * Description:
 */
public class ForInsteadTestWhile {
    public static void main(String[] args) {
        int count = 0;
        for (; count < 10;){
            System.out.println(count);
            count ++;
        }

        System.out.println("循环结束");
    }
}
