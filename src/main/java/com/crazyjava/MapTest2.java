package com.crazyjava;

import java.util.HashMap;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:25
 * @Description:
 */
public class MapTest2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("疯狂java讲义", 149);
        map.put("疯狂ios讲义", 99);
        map.put("疯狂android讲义", 79);
        map.put("轻量级java ee企业应用实战", 99);

        map.replace("疯狂XML讲义", 66);

        System.out.println(map);

        //对应值增大10
        map.merge("疯狂ios讲义", 10, (oldVal, param) -> (Integer)oldVal + (Integer) param);
        System.out.println(map);

        //添加一组key
        map.computeIfAbsent("java", key -> ((String) key).length());
        System.out.println(map);

        //当key为“java”对应值存在时，使用计算的结果作为新的value
        map.computeIfPresent("java", (key, value)->(Integer) value * (Integer) value);
        System.out.println(map);
    }
}
