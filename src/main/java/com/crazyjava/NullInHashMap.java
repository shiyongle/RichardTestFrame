package com.crazyjava;

import java.util.HashMap;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:42
 * @Description:
 */
public class NullInHashMap {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put(null, null);
        hm.put(null, null);
        hm.put("a", null);

        System.out.println(hm);
    }
}
