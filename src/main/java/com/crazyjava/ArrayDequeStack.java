package com.crazyjava;

import java.util.ArrayDeque;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:03
 * @Description:
 */
public class ArrayDequeStack {
    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque();
        stack.push("疯狂java讲义");
        stack.push("轻量级java ee企业应用实战");
        stack.push("疯狂android讲义");

        System.out.println(stack);
        //访问第一个元素
        System.out.println(stack.peek());

        System.out.println(stack.pop());
    }
}
