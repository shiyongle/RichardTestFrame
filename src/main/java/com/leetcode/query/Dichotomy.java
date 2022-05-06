package com.leetcode.query;

/**
 * 二分法查询
 * 查询思路：
 * 每次查询中间元素，小了的话，便修改start，大了的话，就修改end
 */

public class Dichotomy {

    /**
     * 有序数组
     * @param arr
     * @param item
     * @return
     */
    public static int binary_search(int arr[], int item){

        int start = 0;

        int end = arr.length - 1;

        while (start <= end){

            int mid = (start + end) / 2;

            int guess = arr[mid];

            if ( guess == item){
                return mid;
            }
            if (guess > item){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 有序数组
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length -1;

        while (left<=right){
            int mid = (left+right) / 2;
            if (key == array[mid]){
                return mid;
            }else if (key < array[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,3,5,7,9,11,13,15,17,19};
        System.out.println(binary_search(arr, 17));
        System.out.println(binarySearch(arr, 19));
    }
}
