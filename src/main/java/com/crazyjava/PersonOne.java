package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/16 21:06
 * @Description:
 */
public class PersonOne {
    {
        int a = 6;
        if (a > 4) {
            System.out.println("PersonOne实例初始化块：局部变量a的值大于4");
        }
        System.out.println("Person的实例初始化块");
    }

    {
        System.out.println("PersonOne的第二个实例初始化块");
    }

    public PersonOne(){
        System.out.println("PersonOne的无参构造器");
    }

    public static void main(String[] args) {
        new PersonOne();
    }
}
