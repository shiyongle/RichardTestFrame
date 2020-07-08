package com.crazyjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/7/8 21:54
 * @Description:  list容器是后进先出
 */
public class FixedSizeList {
    public static void main(String[] args) {
        //Array.ArrayList是固定长度的list集合，不可随意添加或者删除
        List<String> fixedList = Arrays.asList("疯狂java讲义", "轻量java ee企业应用实战");
        System.out.println(fixedList.getClass());

        fixedList.forEach(System.out::println);
        fixedList.add("疯狂java讲义");
        fixedList.remove("疯狂java讲义");
    }
}
