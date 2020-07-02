package com.crazyjava;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: Richered
 * @Date: 2020/7/2 15:22
 * Description:
 */
public class Airth {
    private static final int DEF_DIV_SCALE = 10;

    private Airth(){
    }

    //提供精确的加法运算
    public static double add(double v1 , double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    //提供精确的减法运算
    public static double sub(double v1 , double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    //提供精确的乘法运算
    public static double mul(double v1 , double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }

    //提供精确的除法运算;精确到小数点以后10位的数字，四舍五入
    public static double div(double v1 , double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, DEF_DIV_SCALE, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println("0.05 + 0.01 = " + Airth.add(0.05, 0.01));
        System.out.println("1.0 + 0.42 = " + Airth.sub(1.0, 0.42));
        System.out.println("4.015 + 100 = " + Airth.mul(4.015, 100));
        System.out.println("123.3 + 100 = " + Airth.div(123.3, 100));
    }
}
