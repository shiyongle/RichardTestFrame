package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/14 23:41
 * @Description:
 */
public class Apples extends Fruit {

    @Deprecated(since = "9", forRemoval = true)
    public void info(){
        System.out.println("苹果重写水果的info方法");
    }

    public static void main(String[] args) {
        Apples a = new Apples();
        a.weight = 56;
        a.info();
    }
}
