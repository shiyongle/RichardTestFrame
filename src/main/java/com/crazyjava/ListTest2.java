package com.crazyjava;

import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/7/8 21:34
 * @Description:
 */
public class ListTest2 {
    public static void main(String[] args) {
        ArrayList books = new ArrayList();
        books.add("轻量java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂ios讲义");
        System.out.println(books);

        books.remove(new AOne());

        System.out.println(books);

        books.remove(new AOne());

        System.out.println(books);
    }
}
