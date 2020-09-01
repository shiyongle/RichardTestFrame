package com.crazyjava;

import java.io.Serializable;

/**
 * @Author: Richered
 * @Date: 2020/08/26 13:34
 * @Description:
 **/
public class PersonSerializable implements Serializable {

    private String name;

    private int age;

    public PersonSerializable(String name, int age){
        System.out.println("存在参数的构造");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
