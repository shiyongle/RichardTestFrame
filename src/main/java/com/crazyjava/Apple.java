package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/12 0:25
 * @Description:
 */
public class Apple {
    public String name;
    public String color;
    public double weight;
    public Apple(String name, String color){
        this.name = name;
        this.color = color;
    }

    public Apple(String name, String color, double weight){
        this(name, color);
        this.weight = weight;
    }
}
