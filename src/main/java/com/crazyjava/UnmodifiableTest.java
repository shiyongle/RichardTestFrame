package com.crazyjava;

import java.util.*;

/**
 * @Author: Richered
 * @Date: 2020/7/12 22:35
 * @Description:
 */
public class UnmodifiableTest {
    public static void main(String[] args) {
        //创建一个空的、不可改变的list对象
        Collection<Objects> unmodifiableList = Collections.emptyList();

        //创建只有一个元素，且不可变的set对象
        Set<String> unmodifiableSet = Collections.singleton("疯狂java讲义");

        //创建普通的map对象
        HashMap scores = new HashMap();
        scores.put("语文", 80);
        scores.put("java", 92);

        //不可变的集合对象只能访问集合元素，不可修改集合元素
        Map<Object, Object> unmodifiableMap = Collections.unmodifiableMap(scores);
//        unmodifiableMap.add("测试元素");
    }
}
