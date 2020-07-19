package com.crazyjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:11
 * @Description:
 */
public class RightTest {
    static <T> void test(Collection<? extends T> from, Collection<T> to){
        for (T ele : from){
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> ao = new ArrayList<>();
        List<Object> as = new ArrayList<>();
        test(ao, as);
    }
}
