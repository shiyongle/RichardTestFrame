package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 杨辉三角变形
 */
public class YangHuiTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if(num == 1 || num == 2){
                System.out.println(-1);
                continue;
            }
            else if(num % 4 == 1 || num % 4 == 3){
                System.out.println(2);
                continue;
            }
            else if(num % 4 == 0){
                System.out.println(3);
                continue;
            }
            else if(num % 4 == 2){
                System.out.println(4);
                continue;
            }
        }
    }
}
