package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:07
 * @Description:
 */
public class ForEachErrorTest {
    public static void main(String[] args) {
        String[] books = {"轻量级java教程", "疯狂java讲义", "java编程思想"};
        for (String b:books) {
            b = "疯狂java讲义";
            System.out.println(b);
        }
        System.out.println(books[0]);
    }
}
