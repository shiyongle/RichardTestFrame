package com.leetcode.sort;

/**
 * @Author: Richered
 * @Date: 2022/3/1 19:39
 * @Description 快速排序
 */
public class FastSort {

    public static void main(String[] args) {
        int[] arr = {5,1,4,6,34,24,7,8};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr){
            System.out.println(i + "\t");
        }
    }

    /**
     *
     * @param arr 待排序列
     * @param leftIndex 待排序列的起始位置
     * @param rightIndex 待排序列的起始位置
     */
    public static void quickSort(int[] arr, int leftIndex, int rightIndex){
        if (leftIndex >= rightIndex){
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //第一个元素为起始基准值
        int key = arr[left];

        //左右交替扫描，直到left=right
        while (left < right){
            while (right > left && arr[right] >= key){
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key){
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }
            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left-1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right+1, rightIndex);
    }
}
