package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:24
 * @Description:
 */
public class InterfaceTest {
    public static void main(String[] args) {
        //可以通过方法赋值来推断泛型为String
        MyUtil<String> ls = MyUtil.nil();

        //无须使用下面语句在调用nil方法时指定泛型的类型
        MyUtil<String> mu = MyUtil.<String>nil();

        //可调用cons方法所需的参数类型来推断泛型为Integer
        MyUtil.cons(42, MyUtil.nil());

        //无须使用下面语句在调用nil方法时指定泛型类型
        MyUtil.cons(42, MyUtil.<Integer>nil());
    }
}
