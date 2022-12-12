package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 统计每个月兔子的总数
 */
public class CountRabbit {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(getTotalCount(n));
        }
    }

    public static int getTotalCount(int monthCount)
    {
        if(monthCount < 3){
            return 1;
        }
        return getTotalCount(monthCount - 2)  + getTotalCount(monthCount - 1) ;
    }
}
