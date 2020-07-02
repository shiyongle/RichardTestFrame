package com.crazyjava;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Richered
 * @Date: 2020/7/2 14:25
 * Description:
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("random.nextBoolean:" + random.nextBoolean());

        byte[] buffer = new byte[16];
        random.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));

        System.out.println("random.nextDouble:" + random.nextDouble());

        System.out.println("random.nextFloat:" + random.nextFloat());

        System.out.println("random.nextGaussian:" + random.nextGaussian());

        System.out.println("random.nextInt:" + random.nextInt());

        System.out.println("random.nextLong:" + random.nextLong());
    }
}
