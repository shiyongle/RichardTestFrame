package com.crazyjava;

import java.util.Date;

/**
 * @Author: Richered
 * @Date: 2020/7/2 15:46
 * Description:
 */
public class DateTest {
    public static void main(String[] args) {
        Date d1 = new Date();
        Date d2 = new Date(System.currentTimeMillis() + 100);
        System.out.println(d2);
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.before(d2));
    }
}
