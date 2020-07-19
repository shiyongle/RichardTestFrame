package com.crazyjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:09
 * @Description:
 */
public class ErrorGenTest {
    static <T> void test(Collection<T> from, Collection<T> to){
        for (T ele : from){
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> as = new ArrayList<>();
        List<String> so = new ArrayList<>();

//        test(as, so);
    }
}
