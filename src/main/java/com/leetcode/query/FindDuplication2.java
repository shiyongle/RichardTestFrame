package com.leetcode.query;

/**
 * @Descriotion 不修改数组找出重复数字
 * @Date 2022/5/6 17:45
 * @Created by shiyl
 */
public class FindDuplication2 {

    public int getDuplication(int[] arr){
        if (arr == null || arr.length-1 <= 0){
            System.out.println("数组输入无效！");
            return -1;
        }
        for (int a : arr){
            if (a < 1|| a > arr.length -1){
                System.out.println("数组大小超出范围!");
                return -1;
            }
        }
        int low = 1;
        int high = arr.length -1;
        int mid, count;
        while (low <= high){
            mid = ((high - low) >> 2) + low;
            count = countRange(arr, low, mid);
            if (low == high){
                if (count > 1){
                    return low;
                }else {
                    break;
                }
            }
            if (count > mid -low +1){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return  -1;
    }

    public int countRange(int[] arr, int low, int high){
        if (arr == null){
            return 0;
        }
        int count = 0;
        for (int a : arr){
            if (a >= low && a <= high){
                count++;
            }
        }
        return count;
    }

    /**
     * 数组为null
     */
    public void test1(){
        System.out.println("test1:");
        int[] a = null;
        int dup = getDuplication(a);
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
        int dup = getDuplication(a);
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
        int dup = getDuplication(a);
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
        int dup = getDuplication(a);
        if (dup >= 0){
            System.out.println("重复数字为:" + dup);
        }
    }

    public static void main(String[] args) {
        FindDuplication2 f = new FindDuplication2();
        f.test1();
        f.test2();
        f.test3();
        f.test4();
    }
}
