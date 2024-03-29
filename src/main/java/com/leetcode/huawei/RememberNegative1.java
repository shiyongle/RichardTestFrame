package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 记负均正1
 */
public class RememberNegative1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float count1 = 0;
        int count2 = 0;
        float sum = 0;
        while (sc.hasNextInt()){
            int cur = sc.nextInt();
            if (cur >= 0){
                count1++;
                sum += cur;
            }else{
                count2++;
            }
        }
        System.out.println(count2);
        System.out.printf("%.1f\n", sum/count1);
    }
}
