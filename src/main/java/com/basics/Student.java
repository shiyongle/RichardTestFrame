package com.basics;

/**
 * @Author: Richered
 * @Date: 2020/6/2 11:27
 * Description:
 */
public class Student extends Person {

    private String major;

    public Student(String name, String major){
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
