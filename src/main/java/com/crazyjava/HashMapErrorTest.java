package com.crazyjava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:51
 * @Description:
 */
public class HashMapErrorTest {
    public static void main(String[] args) {
        HashMap ht = new HashMap();
        ht.put(new ATwo(60000), "疯狂java讲义");
        ht.put(new ATwo(78778), "轻量级java ee企业应用实战");

        Iterator it = ht.keySet().iterator();
        ATwo first = (ATwo) it.next();

        first.count = 78778;
        System.out.println(ht);

        ht.remove(new ATwo(78778));
        System.out.println(ht);

        System.out.println(ht.get(new ATwo(78778)));
        System.out.println(ht.get(new ATwo(60000)));
    }
}
