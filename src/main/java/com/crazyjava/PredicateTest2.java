package com.crazyjava;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * @Author: Richered
 * @Date: 2020/7/3 23:37
 * @Description:
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        HashSet books = new HashSet();
        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂android讲义");
        books.add("疯狂ios讲义");
        books.add("疯狂ajax讲义");

        //统计书名包含“疯狂”的图书数量，下方一致
        System.out.println(calAll(books, ele->((String) ele).contains("疯狂")));
        System.out.println(calAll(books, ele->((String) ele).contains("java")));
        System.out.println(calAll(books, ele->((String) ele).length() > 10));
    }

    public static int calAll(Collection books, Predicate p){
        int total = 0;
        for (Object obj : books){
            //使用Predicate的test方法判断该对象是否满足Predicate指定的条件
            if (p.test(obj)){
                total++;
            }
        }
        return total;
    }
}
