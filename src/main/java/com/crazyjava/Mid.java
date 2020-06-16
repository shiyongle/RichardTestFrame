package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/16 21:19
 * @Description:
 */
public class Mid extends Root {
    static {
        System.out.println("Mid的类初始化块");
    }

    {
        System.out.println("Mid的实例初始化块");
    }

    public Mid(){
        System.out.println("Mid的无参构造函数");
    }

    public Mid(String msg){
        System.out.println("Mid的带参构造函数，其msg为:"  + msg);
    }
}
