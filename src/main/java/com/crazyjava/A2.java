package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:36
 * @Description:
 */
public class A2 extends AppleGeneric{
    public A2(Object info) {
        super(info);
    }

    public String getInfo(){
        return super.getInfo().toString();
    }
}
