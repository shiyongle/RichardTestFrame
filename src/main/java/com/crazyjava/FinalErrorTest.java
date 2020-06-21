package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/21 23:50
 * @Description:
 */
public class FinalErrorTest {
    final int age;
    {
        printAge();
        age = 6;
        System.out.println(age);
    }

    public void printAge(){
        System.out.println(age);
    }

    public static void main(String[] args) {
        new FinalErrorTest();
    }
}
