package com.crazyjava;

import java.util.Hashtable;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:47
 * @Description:
 */
public class HashtableTest {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        ht.put(new ATwo(60000), "疯狂java讲义");
        ht.put(new ATwo(78778), "轻量级java ee企业应用实战");
        ht.put(new ATwo(1232), new BTwo());

        System.out.println(ht);

        System.out.println(ht.containsValue("测试字符串"));

        System.out.println(ht.containsKey(new ATwo(78778)));

        ht.remove(new ATwo(1232));
        System.out.println(ht);
    }
}
