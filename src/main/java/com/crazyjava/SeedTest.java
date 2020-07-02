package com.crazyjava;

import java.util.Random;

/**
 * @Author: Richered
 * @Date: 2020/7/2 14:46
 * Description:
 */
public class SeedTest {
    public static void main(String[] args) {
        Random r1 = new Random(50);
        System.out.println("第一个种子为50的Random对象");

        System.out.println("r1.nextBoolean: \t" + r1.nextBoolean());
        System.out.println("r1.nextInt: \t" + r1.nextInt());
        System.out.println("r1.nextDouble: \t" + r1.nextDouble());
        System.out.println("r1.nextGaussian: \t" + r1.nextGaussian());

        System.out.println("-------------------");

        Random r2 = new Random(50);
        System.out.println("第一个种子为50的Random对象");
        System.out.println("r2.nextBoolean: \t" + r2.nextBoolean());
        System.out.println("r2.nextInt: \t" + r2.nextInt());
        System.out.println("r2.nextDouble: \t" + r2.nextDouble());
        System.out.println("r2.nextGaussian: \t" + r2.nextGaussian());

        System.out.println("-------------------");
        Random r3 = new Random(100);
        System.out.println("种子为100的Random对象");
        System.out.println("r3.nextBoolean: \t" + r3.nextBoolean());
        System.out.println("r3.nextInt: \t" + r3.nextInt());
        System.out.println("r3.nextDouble: \t" + r3.nextDouble());
        System.out.println("r3.nextGaussian: \t" + r3.nextGaussian());

        Random rand = new Random(System.currentTimeMillis());
        System.out.println(rand.nextInt());
    }
}
