package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 13:40
 * Description:
 */
public class ATest {
    public static void main(String[] args) {
        int age = 8;
        A a = new A() {
            @Override
            public void test() {
                //jdk1.8开始，匿名内部类，局部内部类允许访问非final的局部变量
                System.out.println(age);
            }
        };
        a.test();
    }
}
