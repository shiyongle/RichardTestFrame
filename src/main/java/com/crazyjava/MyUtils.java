package com.crazyjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/7/14 22:11
 * @Description:
 */
public class MyUtils {
    public static <T> T copy(Collection<? super T> dest, Collection<T> src){
        T last = null;
        for (T ele: src){
            last = ele;
            dest.add(ele);
        }
        return last;
    }

    public static void main(String[] args) {
        List In = new ArrayList<Number>();
        List li = new ArrayList<Integer>();
        li.add(5);

        Integer last = (Integer) copy(In, li);
        System.out.println(In);
    }
}
