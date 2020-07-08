package com.crazyjava;

import java.util.LinkedHashMap;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:55
 * @Description:
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap scores = new LinkedHashMap();
        scores.put("语文", 80);
        scores.put("数学", 82);
        scores.put("英语", 76);

        scores.forEach((key, value)->System.out.println(key + "-->" + value));
    }
}
