package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:40
 * @Description:
 */
public class RGeneric<T> {

//    static T info;  不能在静态变量声明中使用泛型形参
    T age;
    public void foo(T msg){
    }

    //不能在静态方法声明中使用泛型形参
//    public static void bar(T msg){
//
//    }
}
