package com.crazyjava;

import java.util.TreeSet;

/**
 * @Author: Richered
 * @Date: 2020/7/6 22:14
 * @Description:
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet nums = new TreeSet();
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);

        System.out.println(nums);

        System.out.println(nums.first());

        System.out.println(nums.last());

        //返回小于4的元素
        System.out.println(nums.headSet(4));
        //大于4的
        System.out.println(nums.tailSet(4));
        //大于-3，小4
        System.out.println(nums.subSet(-3,4));
    }
}
