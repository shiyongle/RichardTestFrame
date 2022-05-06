package com.leetcode.query;

import org.junit.jupiter.api.Test;

/**
 * @Descriotion 找出数组中的重复数字
 * @Date 2022/5/6 17:31
 * @Created by shiyl
 *
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。
 */
public class FindDuplication {

    public int getDuplicate(int[] arr){
        if (arr == null || arr.length <= 0){
            System.out.println("无效数组!");
            return -1;
        }

        for (int a : arr){
            if (a < 0 || a > arr.length -1){
                System.out.println("数字大小超出范围！");
                return -1;
            }
        }

        for (int i = 0; i < arr.length; i++){
            int temp;
            while (arr[i] != i){
                if (arr[arr[i]] == arr[i]){
                    return arr[i];
                }
                temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        System.out.println("数组中无重复数字！");
        return -1;
    }

    /**
     * 数组为null
     */
    public void test1(){
        System.out.println("test1:");
        int[] a = null;
        int dup = getDuplicate(a);
        if (dup >= 0){
            System.out.println("重复数字为：" + dup);
        }
    }

    /**
     * 数组无重复数字
     */
    public void test2(){
        System.out.println("test3:");
        int[] a = {0,1,2,3};
        int dup = getDuplicate(a);
        if (dup >= 0){
            System.out.println("重复数字为：" + dup);
        }
    }

    /**
     * 数组越界
     */
    public void test3(){
        System.out.println("test3:");
        int[] a = {1,2,3,4};
        int dup = getDuplicate(a);
        if (dup >= 0){
            System.out.println("重复数字为：" + dup);
        }
    }

    /**
     * 数组带重复数字
     */
    public void test4(){
        System.out.println("test4:");
        int[] a = {1,2,3,4,2};
        int dup = getDuplicate(a);
        if (dup >= 0){
            System.out.println("重复数字为:" + dup);
        }
    }

    public static void main(String[] args) {
        FindDuplication f = new FindDuplication();
        f.test1();
        f.test2();
        f.test3();
        f.test4();
    }
}
