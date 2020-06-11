package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/12 0:18
 * @Description:
 */
public class ConstructorTest {
    public String name;
    public int count;

    public ConstructorTest(String name, int count){
        this.name = name;
        this.count = count;
    }

    public static void main(String[] args) {
        ConstructorTest ct = new ConstructorTest("疯狂java讲义", 3);
        System.out.println(ct.name);
        System.out.println(ct.count);
    }
}
