package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/21 23:44
 * @Description:
 */
public class FinalVariableTest {
    final int a = 6;
    final String str;
    final int c;
    final static double d;

    /**
     * 初始化块可对没有指定默认值的实例变量指定初始值
     */
    {
        str = "Hello";
    }

    /**
     * 静态初始化块，初始静态变量
     */
    static {
        d = 5.6;
    }

    /**
     * 初始化块中已经有初始值的，不可在构造方法中赋值
     */
    public FinalVariableTest(){
        c = 5;
    }

    /**
     * 普通方法不能为final修饰的成员变量赋值
     */
    public void changeFinal(){

    }

    public static void main(String[] args) {
        FinalVariableTest fv = new FinalVariableTest();
        System.out.println(fv.a);
        System.out.println(fv.c);
        System.out.println(fv.d);
    }
}
