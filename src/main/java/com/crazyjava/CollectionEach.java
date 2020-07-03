package com.crazyjava;

import java.util.HashSet;

/**
 * @Author: Richered
 * @Date: 2020/7/3 23:20
 * @Description:
 */
public class CollectionEach {
    public static void main(String[] args) {
        HashSet books = new HashSet();

        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂android讲义");

        books.forEach(obj -> System.out.println("迭代集合元素：" + obj));
    }
}
