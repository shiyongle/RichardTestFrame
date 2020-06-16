package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/14 23:43
 * @Description:
 */
public class Bird {

    private Animal a;

    public Bird(Animal a){
        this.a = a;
    }

    public Bird() {

    }

    public void breathe(){
        a.breathe();
    }

    public void fly(){
        System.out.println("我在天空自由自在的飞翔·~~~");
    }
}
