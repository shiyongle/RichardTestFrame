package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:18
 * @Description:
 */
public class MyClass<E> {
    public <T> MyClass(T t){
        System.out.println("t 的参数值为：" + t);
    }
}
