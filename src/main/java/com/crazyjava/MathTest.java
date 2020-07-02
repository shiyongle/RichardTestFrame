package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/8 21:10
 * @Description: Math常用方法：开方，乘方等
 */
public class MathTest {
    public static void main(String[] args) {
        double a = 3.2;
        //求a的五次方
        double b = Math.pow(a , 5);
        System.out.println(b);

        //求a的平方根
        double c = Math.sqrt(a);
        System.out.println(c);

        //随机数
        double d = Math.random();
        System.out.println(d);

        double e = Math.sin(a);
        System.out.println(e);

        /**
         * 下方是三角运算
         */

        //将弧度转换成角度
        System.out.println("Math.toDegrees:" + Math.toDegrees(1.57));

        //将角度转换成弧度
        System.out.println("Math.toRadians:" + Math.toRadians(90));

        //计算反余弦，返回角度范围在0.0到pi之间
        System.out.println("Math.acos:" + Math.acos(1.2));

        //计算反正弦，返回角度在-pi/2到pi/2之间
        System.out.println("Math.asin:" + Math.asin(0.8));

        //计算反正切
        System.out.println("Math.atan : " + Math.atan(1.57));

        //计算三角余弦
        System.out.println("Math.cos:" + Math.cos(1.57));

        //计算双曲余弦
        System.out.println("Math.cosh:" + Math.cosh(1.2));

        //计算正弦
        System.out.println("Math.sin:" + Math.sin(1.57));


        System.out.println("Math.sinh:" +Math.sinh(1.2));


        System.out.println("Math.tan:" + Math.tan(0.8));


        System.out.println("Math.tanh" + Math.tanh(2.1));


        System.out.println("Math.atan2:" + Math.atan2(0.1, 0.2));


        System.out.println("Math.floor:" + Math.floor(-1.2));


        System.out.println("Math.ceil:" + Math.ceil(1.2));


        System.out.println("Math.round:" + Math.round(2.3));


        System.out.println("Math.cbrt:" + Math.cbrt(9));


        System.out.println("Math.exp:" + Math.exp(2));


        System.out.println("Math.hypot:" + Math.hypot(4, 4));


        System.out.println("Math.IEEEremainder:" + Math.IEEEremainder(5, 2));


        System.out.println("Math.pow:" + Math.pow(3, 2));


        System.out.println("Math.log:" + Math.log(12));


        System.out.println("Math.log10:" + Math.log10(9));


        System.out.println("Math.log1p:" + Math.log1p(9));


        System.out.println("Math.abs:" + Math.abs(-4.5));


        System.out.println("Math.copySign:" + Math.copySign(1.2, 1.0));


        System.out.println("Math.signum:" + Math.signum(2.3));


        System.out.println("Math.max:" + Math.max(2.3, 4.5));


        System.out.println("Math.min:" + Math.min(1.2, 3.4));


        System.out.println("Math.nextAfter:" + Math.nextAfter(1.2, 1.0));


        System.out.println("Math.nextUp:" + Math.nextUp(1.2));


        System.out.println("Math.random:" + Math.random());
    }
}
