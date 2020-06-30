package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 16:35
 * Description: 不允许在非静态内部类里边定义静态成员
 */
public class InnerNoStatic {
    private class InnerClass{
//        //报错
////        static {
////            System.out.println("========");
////        }
//
//        private static int inProp;
//        private static void test(){};
    }
}
