package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 14:46
 * Description:
 */
public class VarInLambda {
    public static void main(String[] args) {
        Runnable run  = (Runnable)() ->{
          for (int i = 0; i < 100; i ++){
              System.out.println();
          }
        };
    }
}
