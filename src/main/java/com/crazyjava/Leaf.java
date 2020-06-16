package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/16 21:22
 * @Description:
 */
public class Leaf extends Mid{
    static {
        System.out.println("Leaf的类初始化块");
    }

    {
        System.out.println("Leaf的实例初始化块");
    }

    public Leaf(){
        super("疯狂java讲义");
        System.out.println("执行Leaf的构造器");
    }
}
