package com.leetcode.huawei;

import java.util.Scanner;

/**
 * @Descriotion 近似值
 * @Date 2022/5/9 14:47
 * @Created by shiyl
 */
public class ApproximateValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        System.out.println((int) (number+0.5));
    }
}
