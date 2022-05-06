package com.leetcode.query;

/**
 * @Author: Richered
 * @Date: 2022/2/22 15:19
 * @Description 斐波那契数列
 */
public class Fibonacci {

    public static long finbonaccitest(long number){
        if ((number == 0) || (number == 1)){
            return number;
        }else {
            return finbonaccitest(number - 1) + finbonaccitest(number - 2);
        }
    }

    public static void main(String[] args) {
        for (int counter = 0; counter <= 10; counter++){
            System.out.printf("Fibonacci of %d is: %d ",
                    counter, finbonaccitest(counter));
        }
    }
}
