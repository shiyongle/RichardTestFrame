package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/21 23:37
 * @Description:
 */
public class SingletonTest {
    public static void main(String[] args) {
        //两次产生的对象是同一个实例，因此为true；单例模式的优势
        Singleton l1 = Singleton.getInstance();
        Singleton l2 = Singleton.getInstance();
        System.out.println(l1 == l2);
    }
}
