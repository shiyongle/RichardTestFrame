package com.castheima;

/**
 * @Author: Richered
 * @Date: 2021/7/5 23:18
 * @Description
 */
public class Calculator {

    @Check
    public void add(){
        System.out.println("1 + 0" + (1 + 0));
    }

    @Check
    public void sub(){
        System.out.println("1 - 0" + (1 - 0));
    }

    @Check
    public void mul(){
        System.out.println("1 * 0" + (1 * 0));
    }

    @Check
    public void div(){
        System.out.println("1 / 0 " + (1 / 0));
    }

    public void show(){
        System.out.println("永无bug....");
    }
}
