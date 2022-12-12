package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 二维数组的操作
 */
public class TowDimenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r, c, r1, c1, r2, c2, ri, ci, rt, ct;
        while (sc.hasNext()) {
            r = sc.nextInt();
            c = sc.nextInt();
            r1 = sc.nextInt();
            c1 = sc.nextInt();
            r2 = sc.nextInt();
            c2 = sc.nextInt();
            ri = sc.nextInt();
            ci = sc.nextInt();
            rt = sc.nextInt();
            ct = sc.nextInt();
            if (r <= 9 && c <= 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            if ((r1 < r && r2 < r) && (c1 < c && c2 < c)) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            //插入行和列的时候,要注意,只有在原来的行和列是小于9的情况下才能插入
            if (ri < r && r < 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            if (ci < c && c < 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            //无论怎么插入行和列, 表格永远是初始的规格大小
            if (rt < r && ct < c) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
