package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 22:43
 * @Description:
 */
public class Dog {
    public void jump(){
        System.out.println("正在执行jump方法");
    }

    public void run(){
        this.jump();
        System.out.println("正在执行run方法");
    }

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println("Person对象是否equals Dog对象：" + p.equals(new Dog()));
        System.out.println("Person对象是否equals String对象：" + p.equals(new String("Hello")));
    }
}
