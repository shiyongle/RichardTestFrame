package com.crazyjava;

import java.util.stream.IntStream;

/**
 * @Author: Richered
 * @Date: 2020/7/6 21:07
 * @Description:
 */
public class IntStreamTest {
    public static void main(String[] args) {
        IntStream is = IntStream.builder()
                .add(20)
                .add(13)
                .add(-2)
                .add(18)
                .build();

        System.out.println("is所有元素的最大值是：" + is.max().getAsInt());
        System.out.println("is所有元素的最小值是：" + is.min().getAsInt());
        System.out.println("is所有元素的总和是：" + is.sum());
        System.out.println("is所有元素的总数是：" + is.count());
        System.out.println("is所有元素的平均值是：" + is.average());
        System.out.println("is所有元素的平方是否都大于20：" + is.allMatch(ele -> ele*ele > 20));
        System.out.println("is是否包含任何元素的平方大于20：" + is.anyMatch(ele -> ele*ele > 20));

        //将is映射成一个新的IntStream，新stream的每个元素是原stream元素的2倍+1
        IntStream newIs = is.map(ele -> ele * 2 + 1);

        //使用方法引用的方式来遍历元素
        newIs.forEach(System.out::println);
    }
}
