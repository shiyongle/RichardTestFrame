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
        Object oa = new Object[100];
        Collection<Object> co = new ArrayList<>();
        //T代表Object类型
//        fromArrayToCollection(oa, co);

        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<>();
        //T代表Object类型
        fromArrayToCollection(sa, co);

        //T代表String类型
        fromArrayToCollection(sa, cs);

        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];

        Collection<Number> cn = new ArrayList<>();

        //T代表Number类型
        fromArrayToCollection(ia, cn);

        //T代表Number类型
        fromArrayToCollection(fa, cn);

        //T代表Number类型
        fromArrayToCollection(na, cn);

        //T代表Object类型
        fromArrayToCollection(na, co);
    }
}
