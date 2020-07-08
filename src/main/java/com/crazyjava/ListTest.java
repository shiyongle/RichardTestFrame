package com.crazyjava;

import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/7/8 21:27
 * @Description:
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList books = new ArrayList();
        books.add("轻量java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂ios讲义");
        System.out.println(books);

        books.add(1, "疯狂android讲义");
        System.out.println(books);

        for (int i = 0; i < books.size(); i++){
            System.out.println(books.get(i));
        }

        books.remove(2);
        System.out.println(books);
        System.out.println(books.indexOf(new String("疯狂Ajax讲义")));

        books.set(1, "疯狂java讲义");
        //将books集合中第二个元素到第三个元素截取成子集合
        System.out.println(books.subList(1, 2));
    }
}
