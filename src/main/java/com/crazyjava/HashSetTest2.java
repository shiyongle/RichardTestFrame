package com.crazyjava;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: Richered
 * @Date: 2020/7/6 21:44
 * @Description:
 */
public class HashSetTest2 {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(new HashSetR(5));
        hs.add(new HashSetR(-3));
        hs.add(new HashSetR(9));
        hs.add(new HashSetR(-2));

        System.out.println(hs);

        //取出第一个元素
        Iterator it = hs.iterator();
        HashSetR first = (HashSetR)it.next();

        //改变第一个元素的值
        first.count = -3;

        System.out.println(hs);

        //删除-3
        hs.remove(new HashSetR(-3));

        System.out.println(hs);

        System.out.println("hs是否包含count为-3的HashSetR对象？" + hs.contains(new HashSetR(-3)));
        System.out.println("hs是否包含count为-2的HashSetR对象？" + hs.contains(new HashSetR(-2)));
    }
}
