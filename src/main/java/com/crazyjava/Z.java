package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/6 22:22
 * @Description:
 */
public class Z implements Comparable{

    int age;

    public Z(int age){
        this.age = age;
    }

    @Override
    public int compareTo(Object obj) {
        return 1;
    }

    public boolean equals(Object obj){
        return true;
    }
}
