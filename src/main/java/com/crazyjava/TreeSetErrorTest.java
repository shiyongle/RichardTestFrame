package com.crazyjava;

import java.util.Date;
import java.util.TreeSet;

/**
 * @Author: Richered
 * @Date: 2020/7/6 22:18
 * @Description:
 */
public class TreeSetErrorTest {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();

        //如果试图把一个对象添加到TreeSet中去，必须实现compareable接口
        ts.add(new Err());

        //向TreeSet集合添加两个对象，也会报错
        ts.add(new Date());
        ts.add(new String("疯狂java讲义"));
    }
}
