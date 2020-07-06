package com.crazyjava;

import java.util.TreeSet;

/**
 * @Author: Richered
 * @Date: 2020/7/6 22:25
 * @Description:
 */
public class TreeSetTest2 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        Z z1 = new Z(6);

        set.add(z1);

        System.out.println(set.add(z1));

        System.out.println(set);

        ((Z)(set.first())).age = 9;

        System.out.println(((Z)(set.last())).age);
    }
}
