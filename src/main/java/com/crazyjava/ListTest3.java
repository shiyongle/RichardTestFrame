package com.crazyjava;

import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/7/8 21:37
 * @Description:
 */
public class ListTest3 {
    public static void main(String[] args) {
        ArrayList books = new ArrayList();
        books.add("轻量java ee企业应用实战");
        books.add("疯狂java讲义");
        books.add("疯狂ios讲义");
        System.out.println(books);

        //使用目标类型为Comparator的lambda表达式对list集合排序
        //字符串越长越靠后
        books.sort((o1, o2) -> ((String) o1).length() - ((String) o2).length());
        System.out.println(books);

        //使用目标类型为UnaryOperator的lambda表达式来替换集合中所有元素
        //该lambda表达式控制使用每个字符串的长度作为新的集合元素
        books.replaceAll(ele -> ((String) ele).length());
        System.out.println(books);
    }
}
