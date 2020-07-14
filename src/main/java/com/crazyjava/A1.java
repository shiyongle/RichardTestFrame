package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:35
 * @Description:
 */
public class A1 extends AppleGeneric<String>{

    public A1(String info) {
        super(info);
    }

    public String getInfo(){
        return "子类" + super.getInfo();
    }
}
