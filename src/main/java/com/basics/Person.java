package com.basics;

/**
 * @Author: Richered
 * @Date: 2020/6/2 11:24
 * Description:
 */
public abstract class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    //抽象方法通常充当占位角色
    public abstract String getDescription();

    public String getName(){
        return name;
    }
}
