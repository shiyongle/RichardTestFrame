package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/20 18:00
 * Description:
 */
public class OverrideEqualsRight {
    public static void main(String[] args) {
        Person p1 = new Person("孙悟空", "123456498498");
        Person p2 = new Person("孙行者", "123456498498");
        Person p3 = new Person("孙悟饭", "99565656");

        System.out.println("p1和p2是否相等：" + p1.equals(p2));
        System.out.println("p2和p3是否相等：" + p2.equals(p3));
    }
}
