package com.leetcode.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入n个整数，输出其中最小的第K个
 */
public class ConsuloK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            for(int i=0;i<k;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
