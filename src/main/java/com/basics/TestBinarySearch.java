package com.basics;

import java.util.Arrays;

/**
 * @Author: Richered
 * @Date: 2020/5/19 0:55
 * @Description:二分法查找
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = {30,20,50,10,80,90,100,40};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(myBinarySearch(arr, 40));
    }

    public static int myBinarySearch(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (value == arr[mid]   ){
                return mid;
            }
            if (value > arr[mid]){
                low = mid + 1;
            }
            if (value < arr[mid]){
                high = mid - 1;
            }
        }
        return -1;
    }
}
