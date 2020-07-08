package com.crazyjava;

import java.util.ArrayDeque;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:07
 * @Description:  可做队列
 */
public class ArrayDequQueue {
    public static void main(String[] args) {
        ArrayDeque queue = new ArrayDeque();
        queue.offer("疯狂java讲义");
        queue.offer("轻量级java ee企业应用实战");
        queue.offer("疯狂android讲义");

        System.out.println(queue);

        System.out.println(queue.peek());

        //poll出第一个元素
        System.out.println(queue.poll());
    }
}
