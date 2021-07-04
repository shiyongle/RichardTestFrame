package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/09/29 19:55
 * @Description:
 **/
public class DaemonThread extends Thread{

    public void run(){
        for (int i = 0; i < 1000; i ++){
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread t = new DaemonThread();
        t.start();
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
