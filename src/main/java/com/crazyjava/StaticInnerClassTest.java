package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 16:43
 * Description:
 */
public class StaticInnerClassTest {

    private int prop1 = 5;

    private static int prop2 = 9;

    static class StaticInnerClass{
        private static int age;

        public void accessOuterProp(){
            System.out.println(prop2);      //不可访问prop1,静态内部类无法访问外部类的实例变量
        }
    }
}
