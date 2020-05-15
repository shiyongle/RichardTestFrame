package com.basics;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: Richered
 * @Date: 2020/5/13 15:36
 * Description:java核心技术for循环抽奖示例
 */
public class LotteryOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("what is the highest number you can draw?");
        int n = in.nextInt();

//        int lotteryOdds = 1;
        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for (int i = 1; i <= k; i++){
//            lotteryOdds = lotteryOdds * (n - i + 1) / i;
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));        //大数值计算
        }
        System.out.println("Your odds are 1 in " + lotteryOdds + ". good luck!");
    }
}
