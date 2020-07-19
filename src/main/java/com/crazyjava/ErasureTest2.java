package com.crazyjava;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:31
 * @Description:
 */
public class ErasureTest2 {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(6);
        li.add(9);

        List list = li;
        List<String> ls = list;
        System.out.println(ls.get(0));
    }
}
