package com.crazyjava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Richered
 * @Date: 2020/7/12 22:41
 * @Description:
 */
public class Java9Collection {
    public static void main(String[] args) {
        Set set = Set.of("java", "kotlin", "Go", "Swift");
        System.out.println(set);
        //不可变集合，添加报错
//        set.add("Ruby");

        List list = List.of(34, -25, 67, 231);
        System.out.println(list);
//        list.remove(1);   不可变集合，报错

        Map<Object, Object> map = Map.of("语文", 89, "数学", 82, "英语", 92);
        System.out.println(map);
//        map.remove("语文");  不可变集合，报错

        Map<Object, Object> map2 = Map.ofEntries(Map.entry("语文", 89), Map.entry("数学", 82), Map.entry("英语", 92));
        System.out.println(map2);
    }
}
