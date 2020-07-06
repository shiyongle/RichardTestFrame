package com.crazyjava;

import java.util.TreeSet;

/**
 * @Author: Richered
 * @Date: 2020/7/6 22:49
 * @Description:
 */
public class TreeSetTest4 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet((o1, o2) -> {
            M m1 = (M) o1;
            M m2 = (M) o2;
            return m1.age > m2.age ? -1 : m1.age < m2.age ? 1 : 0;
        });

        ts.add(new M(5));
        ts.add(new M(-3));
        ts.add(new M(9));
        System.out.println(ts);
    }
}
