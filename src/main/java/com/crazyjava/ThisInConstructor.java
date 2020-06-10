package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 23:16
 * @Description:
 */
public class ThisInConstructor {
    public int foo;
    public ThisInConstructor(){
        int foo = 0;
        this.foo = 6;
    }

    public static void main(String[] args) {
        System.out.println(new ThisInConstructor().foo);
    }
}
