package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/15 0:04
 * @Description:
 */
public class Animal extends Creature {
    public Animal(String name){
        System.out.println("Animal带一个参数的构造器," + "该动物name为" + name);
    }

    public Animal(String name, int age){
        this(name);
        System.out.println("Animal带两个参数的构造器，" + "其age为" + age);
    }
}
