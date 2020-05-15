package com.basics;

import java.util.Scanner;

/**
 * @Author: Richered
 * @Date: 2020/5/12 15:00
 * Description: java核心技术while例子
 */
public class Retirement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How much money do you need to retire?");
        double goal = in.nextDouble();

        System.out.println("How much money do you contribute every year?");
        double payment = in.nextDouble();

        System.out.println("Interest rate in %:");
        double interesRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        while (balance < goal){
            balance += payment;
            double interest = balance * interesRate;
            balance += interest;
            years++;
        }

        System.out.println("You can retire in " + years + " years");
    }
}
