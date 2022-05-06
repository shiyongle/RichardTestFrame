package com.leetcode.query;

/**
 * @Descriotion 从有序数组中删除重复项
 * @Date 2022/5/6 17:14
 * @Created by shiyl
 */
public class Solution {

    public static int removeDuplicates(int[] nums){
        if (nums == null || nums.length <= 0){
            return 0;
        }
        int i = 0, j = 1;
        while (j < nums.length){
            if (nums[i] == nums[j]){
                j++;
            }else {
                nums[++i] = nums[j++];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,1,5,5,5,2,2};
        removeDuplicates(arr);
        for (int i : arr){
            System.out.println(i+ "\t");
        }
    }
}
