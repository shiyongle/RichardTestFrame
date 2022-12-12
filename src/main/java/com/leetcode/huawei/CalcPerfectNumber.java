package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 完全数计算
 */
public class CalcPerfectNumber {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();

            //第一个完全数是6，若小于6则输出0
            if(n < 6){
                System.out.println(0);
                continue;
            }

            int count = 0;    //计数变量
            for(int t=6; t <= n; t++){
                int sum = 0;
                //统计因数的和，计数到该数的1/2即可
                for(int i=1; i <= t/2; i++){
                    if(t%i == 0)
                        sum += i;
                }
                if(sum == t)
                    count++;
            }

            //输出结果
            System.out.println(count);
        }
    }
}
