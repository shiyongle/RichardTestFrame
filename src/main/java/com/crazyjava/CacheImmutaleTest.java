package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/29 21:21
 * @Description:
 */
public class CacheImmutaleTest {
    public static void main(String[] args) {
        CacheImmuale c1 = CacheImmuale.valueOf("hello");
        CacheImmuale c2 = CacheImmuale.valueOf("hello");
        System.out.println(c1 == c2);
    }
}
