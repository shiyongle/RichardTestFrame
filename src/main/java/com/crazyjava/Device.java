package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 13:31
 * Description:
 */
public abstract class Device {
    private String name;
    public abstract double getPrice();

    public Device(){}

    public Device(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
