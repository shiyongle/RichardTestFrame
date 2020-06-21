package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/22 0:08
 * @Description:
 */
public class SubFinal extends FinalMethodTest {
    public void test(){}        //如果父类的修饰符为public,不可重写final方法；如果为private，其实是重新定义了一个同名的方法
}
