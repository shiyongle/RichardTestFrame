package com.crazyjava;

import java.util.HashSet;

/**
 * @Author: Richered
 * @Date: 2020/7/6 21:32
 * @Description:
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet books = new HashSet();

        books.add(new HashSetA());
        books.add(new HashSetA());
        books.add(new HashSetB());
        books.add(new HashSetB());

        //因为C类重写了equals和hashcode的方法，将导致HashSet把两个C对象当成同一个对象
        //可见当把一个对象放入HashSet中，必须重写其hashcode和equals方法，equals比较返回true，那么其hashcode也应该相同
        books.add(new HashSetC());
        books.add(new HashSetC());

        System.out.println(books);
    }
}
