package com.crazyjava;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @Author: Richered
 * @Date: 2020/7/6 22:10
 * @Description:
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();

        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂android讲义");

        books.remove("疯狂java讲义");

        System.out.println(books);
        books.add("疯狂ios讲义");
        System.out.println(books);
    }
}
