package com.crazyjava;

import java.util.EnumSet;
import java.util.HashSet;

/**
 * @Author: Richered
 * @Date: 2020/7/6 22:59
 * @Description:
 */
public class EnumSetTest2 {
    public static void main(String[] args) {
        HashSet c = new HashSet();
        c.clear();
        c.add(Season.FALL);
        c.add(Season.SPRING);

        EnumSet enumSet = EnumSet.copyOf(c);
        System.out.println(enumSet);

        c.add("疯狂java讲义");

        //不全部是枚举 则会报错
        enumSet = EnumSet.copyOf(c);
    }
}
