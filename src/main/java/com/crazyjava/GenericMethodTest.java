package com.crazyjava;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: Richered
 * @Date: 2020/7/14 22:31
 * @Description:
 */
public class GenericMethodTest {
    static <T> void fromArrayToCollection(T[] a, Collection<T> c){
        for (T o : a){
            c.add(o);
        }
    }

    public static void main(String[] args) {
        Object oa = new Object();
        Collection<Object> co = new ArrayList<>();
        //T代表Object类型
    }
}
