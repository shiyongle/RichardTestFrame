package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:22
 * @Description:
 */
public class ReferenceArrayTest {
    public static void main(String[] args) {
        Person[] students;
        students = new Person[2];

        Person zhang = new Person();

        zhang.age = 15;
        zhang.height = 158;

        Person lee = new Person();

        lee.age = 16;
        lee.height = 170;

        students[0] = zhang;
        students[1] = lee;

        lee.info();
        students[1].info();

    }
}
