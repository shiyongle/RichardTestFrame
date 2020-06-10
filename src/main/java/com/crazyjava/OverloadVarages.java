package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 23:45
 * @Description:
 */
public class OverloadVarages {
    public void test(String msg){
        System.out.println("只有一个参数的test方法" + msg);
    }

    public void test(String... books){
        System.out.println("******形参个数可变的test方法********" );
    }

    public static void main(String[] args) {
        OverloadVarages olv = new OverloadVarages();
        olv.test("aa");
        olv.test();
        olv.test("aa","bb","cc");
        olv.test(new String[]{"dd"});
    }
}
