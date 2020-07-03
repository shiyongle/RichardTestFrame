package com.crazyjava;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: Richered
 * @Date: 2020/7/3 23:30
 * @Description:
 */
public class IterationEach {
    public static void main(String[] args) {
        HashSet books = new HashSet();
        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂android讲义");

        Iterator it = books.iterator();
        it.forEachRemaining(obj ->System.out.println("迭代集合元素：" + obj));
    }
}
