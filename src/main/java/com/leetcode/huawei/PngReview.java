package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 图片整理
 */
public class PngReview {
    public static void main(String[] args) {


        Scanner in=new Scanner(System.in);
            while(in.hasNext()){
            int a[]=new int[128];
            String str=in.next();
            for(int i=0;i<str.length();i++){
                int k=str.charAt(i);//统计出现次数
                a[k]++;
            }
            for(int j=48;j<a.length;j++){//从'0'开始输出
                if(a[j]!=0)
                    for(int b=0;b<a[j];b++)
                        System.out.print((char)j);
            }
            System.out.println();
        }
    }
}
