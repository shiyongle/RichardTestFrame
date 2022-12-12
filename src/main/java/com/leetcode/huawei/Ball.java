package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 求小球落地5次后所经历的路程和第5次反弹的高度
 */
public class Ball {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            System.out.println(a*(1+2*Math.pow(0.5,1)+2*Math.pow(0.5,2)+2*Math.pow(0.5,3)+2*Math.pow(0.5,4)));
            System.out.println(a*Math.pow(0.5,5));
        }
    }
}
