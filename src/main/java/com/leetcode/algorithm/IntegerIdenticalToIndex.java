package com.leetcode.algorithm;

/**
 * @Descriotion 数组中数值和下标相等的元素
 * @Date 2022/5/7 0:27
 * @Created by shiyl
 */
public class IntegerIdenticalToIndex {
    public int getNumberSameAsIndex(int[] arr) {
        if(arr==null || arr.length<=0)
            return -1;  //代表错误
        int low=0;
        int high=arr.length-1;
        while(low<=high) {
            int mid= (high+low)>>1;
            if(arr[mid]>mid)
                high=mid-1;
            else if(arr[mid]<mid)
                low=mid+1;
            else
                return mid;
        }
        return -1;
    }
}
