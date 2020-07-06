package com.crazyjava;

import java.util.HashSet;

/**
 * @Author: Richered
 * @Date: 2020/7/6 21:18
 * @Description:
 */
public class CollectionStream {
    public static void main(String[] args) {
        HashSet books = new HashSet();

        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂android讲义");

        //统计书名包含疯狂的字符串
        System.out.println(books.stream().filter(ele -> ((String)ele).contains("疯狂")).count());

        System.out.println(books.stream().filter(ele -> ((String)ele).contains("java")).count());

        //统计书名字符串长度大于10
        System.out.println(books.stream().filter(ele -> ((String)ele).length() > 10));

        //调用collection对象的stream方法将集合转换为Stream；再调用Stream的mapToInt方法获取原有的Stream对应的IntStream
        books.stream().mapToInt(ele -> ((String) ele).length()).forEach(System.out::println);
    }
}
