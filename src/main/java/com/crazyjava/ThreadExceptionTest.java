package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/20 23:15
 * @Description:   多线程异常跟踪
 */
public class ThreadExceptionTest implements Runnable{
    @Override
    public void run() {
        firstMethod();
    }

    public void firstMethod(){
        secondMethod();
    }

    public void secondMethod(){
        int a = 5;
        int b = 0;
        int c = a / b;
    }

    public static void main(String[] args) {
        new Thread(new ThreadExceptionTest()).start();
    }
}
