package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 走方格方案数
 */
public class WalkGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(cal(m,n));
        }

    }
    private static int cal(int m,int n){
        if(m==1 || n== 1){
            return m+n;
        }
        return cal(m-1,n)+cal(m,n-1);
    }
}
