package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/09/29 19:38
 * @Description:
 **/
public class InvokeRun extends Thread{

    private int i;

    public void run(){
        for (; i < 100 ; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i ++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20){
                new InvokeRun().run();
                new InvokeRun().run();
            }
        }
    }
}
