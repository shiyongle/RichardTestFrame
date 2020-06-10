package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/11 0:03
 * @Description:
 */
public class VariableOverrideTest {
    public String name = "李刚";
    public static double price = 78.0;

    public static void main(String[] args) {
        double price = 65;
        System.out.println(price);
        System.out.println(VariableOverrideTest.price);
        new VariableOverrideTest().info();
    }

    public void info(){
        String name = "孙悟空";
        System.out.println(name);
        System.out.println(this.name);
    }
}
