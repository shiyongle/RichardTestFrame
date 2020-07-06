package com.crazyjava;

import java.util.TreeSet;

/**
 * @Author: Richered
 * @Date: 2020/7/6 22:34
 * @Description:
 */
public class TreeSetTest3 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new R(5));
        ts.add(new R(-3));
        ts.add(new R(9));
        ts.add(new R(-2));
        System.out.println(ts);

        R first = (R) ts.first();
        first.count = 20;
        System.out.println(ts);

        R last = (R) ts.last();
        last.count = -2;
        System.out.println(ts);

        //删除实例变量被改变的元素，删除失败
        System.out.println(ts.remove(new R(-2)));
        System.out.println(ts);

        //删除实例变量没有被改变的元素，删除成功
        System.out.println(ts.remove(new R(5)));
        System.out.println(ts);
    }
}
