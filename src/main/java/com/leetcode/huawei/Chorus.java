package com.leetcode.huawei;
import java.util.*;
/**
 * 合唱队
 */
public class Chorus {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] arrL = new int[n]; // 左侧小于arr[i]的个数
            int[] arrR = new int[n]; // 右侧大于arr[i]的个数
            for(int i = 0; i < n; ++i){
                arr[i] = sc.nextInt();
            }

            for(int i = 0; i < n; ++i){
                arrL[i] = 0; // 所以默认初始是0,,对于第一个数来说， 在arr[0]的左侧小于arr[0]的个数是0。
                for(int j = 0; j < i; ++j){
                    if(arr[i] > arr[j]){
                        arrL[i] = Math.max(arrL[j] + 1, arrL[i]);
                    }
                }
            }

            for(int i = n - 1; i >= 0; --i){
                arrR[i] = 0; // 所以默认初始是0,,对于最后一个数来说， 在arr[n - 1]的右侧小于arr[0]的个数是0。
                for(int j = n - 1; j > i; --j){
                    if(arr[i] > arr[j]){
                        arrR[i] = Math.max(arrR[j] + 1, arrR[i]);
                    }
                }
            }

            int maxValue = 0;
            for(int i = 0; i < n; ++i){
                maxValue = Math.max(maxValue, arrR[i] + arrL[i] + 1);
            }

            System.out.println(n - maxValue);
        }
    }
}
