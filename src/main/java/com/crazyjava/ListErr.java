package com.crazyjava;

import java.util.ArrayList;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:09
 * @Description:
 */
public class ListErr {
    public static void main(String[] args) {
        ArrayList strList = new ArrayList();

        strList.add("疯狂java讲义");
        strList.add("疯狂android讲义");

        strList.add(5);
        //Integer对象转换为String类型,会报错
        strList.forEach(str -> System.out.println(((String)str).length()));
    }
}
