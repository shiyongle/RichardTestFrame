package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 求int型正整数在内存中存储时1的个数
 */
public class MemeryInt {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();    //读取数字
        int n = 0;    //计数变量
        for(int i=0; i < 32; i++){
            if((num&1) == 1)    //如果末位为1则计数
                n++;
            num = num >>> 1;    //无符号右移
        }
        System.out.println(n);
    }
}
