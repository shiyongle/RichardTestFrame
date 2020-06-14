package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/14 23:48
 * @Description:
 */
public class SubClass extends BaseClass {
    public int a = 7;
    public void accessOwner(){
        System.out.println(a);
    }

    public void assessBase(){
        System.out.println(super.a);
    }

    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.accessOwner();
        sc.assessBase();
    }
}
