package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/2 11:25
 * Description:
 */
public class User implements Cloneable{
    int age;
    AddressObject addressObject;

    public User(int age){
        this.age = age;
        addressObject = new AddressObject("广州天河");
    }

    public User clone() throws CloneNotSupportedException{
        return (User) super.clone();
    }
}
