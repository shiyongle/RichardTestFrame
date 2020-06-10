package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:24
 * @Description:
 */
public class Person {
    public int age;
    public double height;
    public String name;
    public static int eyeNum;

    public void info(){
        System.out.println("我的年龄是:" + age + "， 我的身高是：" + height);
    }

    public void say(String content){
        System.out.println(content);
    }
}
