package com.crazyjava;

import java.util.*;

/**
 * @Author: Richered
 * @Date: 2020/7/12 22:31
 * @Description:
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Collection<Object> c = Collections.synchronizedCollection(new ArrayList<>());
        Collection<Object> list = Collections.synchronizedList(new ArrayList<>());
        Collection<Object> s = Collections.synchronizedSet(new HashSet<>());
        Map<Object, Object> m = Collections.synchronizedMap(new HashMap<>());
    }
}
