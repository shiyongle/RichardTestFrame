package com.crazyjava;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * @Author: Richered
 * @Date: 2020/7/3 13:31
 * Description: MethodHandles.Lookup对象根据类、方法名、方法类型来获取MethodHandle对象。
 */
public class MethodHandleTest {

    //类方法
    private static void hello(){
        System.out.println("hello world!");
    }

    //实例方法
    private String hello(String name){
        System.out.println("执行带参数的hello :" + name);
        return name + "您好！";
    }

    public static void main(String[] args) throws Throwable{

        //定义一个返回值为void，不带形参的方法类型
        MethodType type = MethodType.methodType(void.class);

        //使用MethodHandles.lookup()的findStatic获取类方法
        MethodHandle mtd = MethodHandles.lookup().findStatic(MethodHandleTest.class, "hello", type);

        //通过MethodHandle执行方法
        mtd.invoke();

        //使用MethodHandles.lookup()的findVirtual获取实例方法；指定获取返回值为String,形参为String
        MethodHandle mtd2 = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "hello", MethodType.methodType(String.class, String.class));

        //通过MethodHandle执行方法，传入主调对象和参数
        System.out.println(mtd2.invoke(new MethodHandleTest(), "孙悟空"));
    }
}
