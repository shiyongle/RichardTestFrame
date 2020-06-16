package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/14 23:58
 * @Description:
 */
public class Base {
    public double size;
    public String name;
    public Base(double size, String name){
        this.size = size;
        this.name = name;
    }

    public Base(){
        test();
    }

    public void test(){
        System.out.println("将被子类重写的方法");
    }
}
