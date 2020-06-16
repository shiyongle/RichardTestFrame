package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/16 21:17
 * @Description:
 */
public class Root {
    static {
        System.out.println("Root的类初始化块");
    }

    {
        System.out.println("Root的实例初始化块");
    }

    public Root(){
        System.out.println("Root的无参构造函数");
    }
}
