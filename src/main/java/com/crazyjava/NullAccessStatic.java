package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/21 23:30
 * @Description:
 */
public class NullAccessStatic {
    private static void test(){
        System.out.println("static修饰的类方法");
    }

    public void second(){
        System.out.println("实例化方法");
    }

    public static void main(String[] args) {
        NullAccessStatic nas = null;
        //使用null对象调用所属类的静态方法
        nas.test();
        //调用实例化方法会报空指针，因为null表明该实例根本不存在，实例不存在那么他的实例变量和方法都不存在
        nas.second();
    }
}
