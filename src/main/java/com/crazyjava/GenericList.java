package com.crazyjava;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:13
 * @Description:
 */
public class GenericList {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        strList.add("疯狂java讲义");
        strList.add("疯狂android讲义");
//        strList.add(2);
        strList.forEach(str -> System.out.println(str.length()));
    }
}
