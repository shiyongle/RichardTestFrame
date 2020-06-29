package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/29 21:39
 * @Description:
 */
public abstract class Shape {
    {
        System.out.println("执行shape的初始化块~~~");
    }

    private String color;

    public abstract double calPermeter();

    public abstract String getType();

    public Shape(){}

    public Shape(String color){
        System.out.println("执行shape的构造器~~");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
