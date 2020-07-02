package com.crazyjava;

import java.math.BigDecimal;

/**
 * @Author: Richered
 * @Date: 2020/7/2 15:08
 * Description:  创建BigDecimal对象时，一定要使用String对象作为构造器参数
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal f1 = new BigDecimal("0.05");
        BigDecimal f2 = BigDecimal.valueOf(0.01);
        BigDecimal f3 = new BigDecimal(0.05);

        System.out.println("使用String作为BigDecimal构造器参数");
        System.out.println("0.05 + 0.01 = " + f1.add(f2));
        System.out.println("0.05 - 0.01 = " + f1.subtract(f2));
        System.out.println("0.05 * 0.01 = " + f1.multiply(f2));
        System.out.println("0.05 / 0.01 = " + f1.divide(f2));

        System.out.println("使用double作为BigDecimal构造器参数");
        System.out.println("0.05 + 0.01 = " + f3.add(f2));
        System.out.println("0.05 - 0.01 = " + f3.subtract(f2));
        System.out.println("0.05 * 0.01 = " + f3.multiply(f2));
        System.out.println("0.05 / 0.01 = " + f3.divide(f2));
    }
}
