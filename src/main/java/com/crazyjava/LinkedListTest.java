package com.crazyjava;

import java.util.LinkedList;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:09
 * @Description:LinkedList作为List集合、双端队列、栈的用法
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList books = new LinkedList();

        //字符串元素加入list尾部
        books.offer("疯狂java讲义");


        //字符串元素加入栈的顶部
        books.push("轻量级java ee企业应用实战");


        //字符串元素加入队列头部
        books.offerFirst("疯狂android讲义");

        for (int i = 0; i < books.size(); i++){
            System.out.println("遍历中：" + books.get(i));
        }

        //访问并不删除栈顶的元素
        System.out.println(books.peekFirst());

        System.out.println(books.peekLast());

        //将栈顶的元素弹出栈
        System.out.println(books.pop());

        System.out.println(books);

        //访问并删除队列的最后一个元素
        System.out.println(books.pollLast());

        System.out.println(books);
    }
}
