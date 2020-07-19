package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:29
 * @Description:
 */
public class ErasureTest {
    public static void main(String[] args) {
        AppleThree<Integer> a = new AppleThree<>(6);
        Integer as = a.getSize();

        AppleThree b = a;

        Number size1 = b.getSize();


//        Integer size2 = b.getSize();   size的类型为Number
    }
}
