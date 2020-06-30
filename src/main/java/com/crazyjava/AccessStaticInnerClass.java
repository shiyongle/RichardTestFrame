package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 17:17
 * Description:
 */
public class AccessStaticInnerClass {
    static class StaticInnerClass{
        private static int prop1 = 5;
        private int prop2 = 9;
    }

    public void accessInnerProp(){
        System.out.println(StaticInnerClass.prop1);

        //通过实例访问静态内部类的实例成员
        System.out.println(new StaticInnerClass().prop2);
    }
}
