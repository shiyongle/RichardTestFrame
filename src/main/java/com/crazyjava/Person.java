package com.crazyjava;

import com.sun.org.apache.bcel.internal.generic.I2F;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:24
 * @Description:
 */
public class Person {
    private int age;
    public double height;
    private String name;
    public static int eyeNum;
    private String idStr;

    public Person(String name, String idStr){
        this.name = name;
        this.idStr = idStr;
    }

    public Person(int age){
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public static int getEyeNum() {
        return eyeNum;
    }

    public String getIdStr() {
        return idStr;
    }

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    public void info(){
        System.out.println("我的年龄是:" + age + "， 我的身高是：" + height);
    }

    public void say(String content){
        System.out.println(content);
    }

    public void setName(String name){
        if (name.length() > 6 || name.length() < 2){
            System.out.println("您设置的人名不符合要求");
            return;
        }else {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age){
        if (age > 100 || age < 0){
            System.out.println("您设置的年龄不合法");
            return;
        }else {
            this.age = age;
        }
    }

    public int getAge(){
        return this.age;
    }

    public boolean equals(Object obj){
        //如果两个为同一个对象
        if (this == obj){
            return true;
        }
        //只有obj是Person对象
        if (obj != null && obj.getClass() == Person.class){
            Person personObj = (Person)obj;
            //并且当前对象idStr与obj对象的idStr相等时才可判断两个对象是相等的
            if (this.getIdStr().equals(personObj.getIdStr())){
                return true;
            }
        }
        return false;
    }
}
