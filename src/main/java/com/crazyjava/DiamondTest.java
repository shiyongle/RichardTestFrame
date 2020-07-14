package com.crazyjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Richered
 * @Date: 2020/7/14 21:17
 * @Description:
 */
public class DiamondTest {
    public static void main(String[] args) {
        List<String> books = new ArrayList<>();
        books.add("疯狂java讲义");
        books.add("疯狂android讲义");

        books.forEach(ele -> System.out.println(ele.length()));

        Map<String, List<String>> schoolInfo = new HashMap<>();
        List<String> schools = new ArrayList<>();
        schools.add("斜月三星洞");
        schools.add("西天取经路");
        schoolInfo.put("孙悟空", schools);

        schoolInfo.forEach((key, value) -> System.out.println(key + "--->" + value));
    }
}
