package com.crazyjava;

import java.util.WeakHashMap;

/**
 * @Author: Richered
 * @Date: 2020/7/12 16:58
 * @Description:
 */
public class WeekHashMapTest {
    public static void main(String[] args) {
        WeakHashMap whm = new WeakHashMap();
        /**添加三个键值对，三个key都是匿名字符串对象，没有其他引用**/
        whm.put(new String("语文"), new String("良好"));
        whm.put(new String("数学"), new String("中等"));
        whm.put(new String("英语"), new String("中等"));

        /**缓存的字符串对象**/
        whm.put("java", new String("中等"));

        System.out.println(whm);

        /**垃圾回收**/
        System.gc();
        System.runFinalization();
        System.out.println(whm);
    }
}
