package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 23:56
 * @Description:
 */
public class ContinueLable {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j ++){
                System.out.println("i的值是：" + i + " j的值是:" + j);
                if (j == 1){
                    continue;
                }
            }
        }
    }
}
