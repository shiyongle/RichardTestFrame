package com.crazyjava;

import java.util.HashSet;

/**
 * @Author: Richered
 * @Date: 2020/7/3 23:31
 * @Description:
 */
public class ForEachIterationTest {
    public static void main(String[] args) {
        HashSet books = new HashSet();
        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂android讲义");

        for (Object obj : books){
            String book = (String) obj;
            System.out.println(book);

            if (book.equals("疯狂android讲义")){
                books.remove(book);
            }
        }
        System.out.println(books);
    }
}
