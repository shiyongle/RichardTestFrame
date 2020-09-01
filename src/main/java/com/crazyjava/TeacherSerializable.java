package com.crazyjava;

import java.io.Serializable;

/**
 * @Author: Richered
 * @Date: 2020/08/26 15:24
 * @Description:
 **/
public class TeacherSerializable implements Serializable {

    private String name;

    private PersonSerializable student;

    public TeacherSerializable(String name, PersonSerializable student){
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonSerializable getStudent() {
        return student;
    }

    public void setStudent(PersonSerializable student) {
        this.student = student;
    }
}
