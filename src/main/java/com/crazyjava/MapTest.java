package com.crazyjava;

import java.util.HashMap;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:19
 * @Description:
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("疯狂java讲义", 149);
        map.put("疯狂ios讲义", 10);
        map.put("疯狂android讲义", 79);
        map.put("轻量级java ee企业应用实战", 99);

        System.out.println(map.put("疯狂ios讲义", 99));
        System.out.println(map);

        System.out.println("是否包含值为 疯狂ios讲义的key:" + map.containsKey("疯狂ios讲义"));
        System.out.println("是否包含值为 99的value:" + map.containsValue(99));

        for (Object key : map.keySet()){
            System.out.println(key + "-->" + map.get(key));
        }
        map.remove("疯狂ajax讲义");
        System.out.println(map);
    }
}
