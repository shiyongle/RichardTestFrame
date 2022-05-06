package com.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class ChoiceSort {

    public static void main(String[] args) {
        int[] nums = {1,9,5,6};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectionSort(int[] arr){

        for (int i=0; i<arr.length -1; i++){
            int minVal = arr[i];        //最小值
            int minIndex = i;           //最小值的索引
            for (int j=i+1; j<arr.length-1; j++){
                if (minVal > arr[j]){
                    minVal = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = minVal;
            }
        }
    }
}
