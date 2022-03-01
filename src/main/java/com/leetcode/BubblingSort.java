package com.leetcode;

import java.util.Arrays;

/**
 * @Author: Richered
 * @Date: 2022/3/1 19:14
 * @Description 冒泡排序
 */
public class BubblingSort {

    public static void main(String[] args) {
        int arr[] = new int[]{1,6,3,5};
        BubblingSort.BubbleSort(arr);
//        BubblingSort.BubbleSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void BubbleSort(int[] arr){
        int temp;
        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){
                if (arr[j+1] < arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /*public static void BubbleSort1(int[] arr){
        boolean flag = true;
        while (flag){
            int temp;
            for (int i=0; i<arr.length-1; i++){
                for (int j=0; j<arr.length-i-1; j++){
                    if (arr[j+1] < arr[j]){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        flag = true;
                    }
                }
                if (!flag){
                    break;
                }
            }
        }
    }*/
}
