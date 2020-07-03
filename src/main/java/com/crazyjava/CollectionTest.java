package com.crazyjava;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author: Richered
 * @Date: 2020/7/3 23:05
 * @Description:
 */
public class CollectionTest {
    public static void main(String[] args) {
        ArrayList c = new ArrayList();

        //添加元素
        c.add("孙悟空");

        //虽然集合里不能放基本类型的值，但java支持自动装箱
        c.add(6);

        System.out.println("c集合的元素个数为：" + c.size());

        c.remove(1);

        System.out.println("c集合的元素个数为：" + c.size());

        System.out.println("c集合是否包含\"孙悟空\"字符串：" + c.contains("孙悟空"));

        c.add("轻量级java ee企业应用实战");

        System.out.println("c集合的元素：" + c);

        HashSet books = new HashSet();
        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        System.out.println("c集合是否完全包含books集合？"  + c.contains(books));

        c.removeAll(books);

        System.out.println("c集合的元素：" + c);

        c.clear();

        System.out.println("c集合的元素：" + c);

        //控制books集合里只剩下c集合里也包含的元素
        books.retainAll(c);

        System.out.println("book集合的元素：" + books);
    }
}
