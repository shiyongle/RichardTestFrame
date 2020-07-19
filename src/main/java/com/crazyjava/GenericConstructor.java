package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:16
 * @Description:
 */
public class GenericConstructor {
    public static void main(String[] args) {
        new FooOne("疯狂java讲义");
        new FooOne(200);
        new <String> FooOne("疯狂java讲义");
//        new <String> Foo(12.3)
    }
}
