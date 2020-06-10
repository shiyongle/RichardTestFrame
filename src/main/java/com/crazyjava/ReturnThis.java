package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 23:19
 * @Description:
 */
public class ReturnThis {
    public int age;
    public ReturnThis grow(){
        age ++;
        return this;
    }

    public static void main(String[] args) {
        ReturnThis rt = new ReturnThis();
        rt.grow().grow().grow();
        System.out.println("rt的age成员变量值是：" + rt.age);
    }
}
