package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 最小公倍数
 */
public class LeastCommonMultiple {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        System.out.println(a*b/gcd(a,b));
    }

    private static int gcd(int a, int b) {
        // TODO Auto-generated method stub
        return b==0?a:gcd(b,a%b);
    }
}
