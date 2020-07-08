package com.crazyjava;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @Author: Richered
 * @Date: 2020/7/8 21:44
 * @Description:
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {"疯狂java讲义", "疯狂ios讲义","轻量级java ee企业应用实战"};

        ArrayList bookList = new ArrayList();
        for (int i = 0; i < books.length; i++){
            bookList.add(books[i]);
        }

        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()){
            System.out.println(lit.next());
            System.out.println("-----分隔符---------");
        }

        System.out.println("-------下面开始反向迭代----------");

        while (lit.hasPrevious()){
            System.out.println(lit.previous());
        }
    }
}
