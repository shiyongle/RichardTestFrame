package com.crazyjava;

import java.util.IdentityHashMap;

/**
 * @Author: Richered
 * @Date: 2020/7/12 17:02
 * @Description: IdentityHashMap对于创建的字符串对象会通过==比较是否相等；字符串直接量，字符序列完全相同，因此下方的java两次
 * 添加会被IdentityHashMap认为是同一个key，只有一次可以添加成功
 */
public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap ihm = new IdentityHashMap();

        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 78);


        ihm.put("java", 98);
        ihm.put("java", 93);

        System.out.println(ihm);
    }
}
