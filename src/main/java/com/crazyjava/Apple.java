package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/12 0:25
 * @Description:
 */
public class Apple {
    private String name;
    private String color;
    private double weight;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Apple(){}

    public Apple(String name, String color){
        this.name = name;
        this.color = color;
    }

    public Apple(String name, String color, double weight){
        this(name, color);
        this.weight = weight;
    }

    public Apple(String color, double weight){
        this.color= color;
        this.weight = weight;
    }

    public String toString(){
        return "一个苹果，颜色是：" + color + ", 重量是:" + weight;
    }
}
