package com.crazyjava;

import java.util.HashSet;

/**
 * @Author: Richered
 * @Date: 2020/7/3 23:34
 * @Description:
 */
public class PredicateTest {
    public static void main(String[] args) {
        HashSet books = new HashSet();
        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂android讲义");
        books.add("疯狂ios讲义");
        books.add("疯狂ajax讲义");

        //过滤条件：长度小于10的字符串元素都会被删除
        books.removeIf(ele -> ((String)ele).length() < 10);

        System.out.println(books);
    }
}
