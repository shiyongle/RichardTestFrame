package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 22:37
 * @Description:
 */
public class PersonTest {

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.name = "李刚");
        p.say("Java is very eazy！");

        System.out.println("Person的eyeNum类变量值：" + Person.eyeNum);
        System.out.println("p变量的name变量值：" + p.name + ", p对象的eyeNum变量值是：" + p.eyeNum);
        p.name = "孙悟空";
        p.eyeNum = 2;
        System.out.println("p变量的name变量值：" + p.name + ", p对象的eyeNum变量值是：" + p.eyeNum);
        System.out.println("Person的eyeNum类变量值：" + Person.eyeNum);

        Person p2 = new Person();
        System.out.println("p2对象的eyeNum类变量值：" + p2.eyeNum);
    }
}
