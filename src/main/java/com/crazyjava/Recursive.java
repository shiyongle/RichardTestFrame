package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 23:40
 * @Description:n 递归  阶乘算法
 */
public class Recursive {
    public static int fn(int n){
        if (n == 0){
            return  1;
        }else if (n == 1){
            return 4;
        }else{
            //自己掉自己
            return 2 * fn(n -1) + fn(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fn(10));
    }
}
