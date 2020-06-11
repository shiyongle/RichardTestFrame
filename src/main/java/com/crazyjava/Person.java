package com.crazyjava;

import com.sun.org.apache.bcel.internal.generic.I2F;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:24
 * @Description:
 */
public class Person {
    private int age;
    public double height;
    private String name;
    public static int eyeNum;

    public void info(){
        System.out.println("我的年龄是:" + age + "， 我的身高是：" + height);
    }

    public void say(String content){
        System.out.println(content);
    }

    public void setName(String name){
        if (name.length() > 6 || name.length() < 2){
            System.out.println("您设置的人名不符合要求");
            return;
        }else {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age){
        if (age > 100 || age < 0){
            System.out.println("您设置的年龄不合法");
            return;
        }else {
            this.age = age;
        }
    }

    public int getAge(){
        return this.age;
    }
}
