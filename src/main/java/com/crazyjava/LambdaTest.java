package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 14:30
 * Description:
 */
public class LambdaTest {
    Runnable r = () ->{
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    };

    Object obj = (Runnable)()->{
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    };

    Object obj1 = (FkTest)()->{
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    };
}
