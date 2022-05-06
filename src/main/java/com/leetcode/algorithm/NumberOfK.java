package com.leetcode.algorithm;

/**
 * @Descriotion 数字在排序数组中出现的次数
 * @Date 2022/5/7 0:24
 * @Created by shiyl
 */
public class NumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null || array.length<=0)
            return 0;
        int firstK = getFirstK(array,0,array.length-1,k);
        if(firstK == -1)
            return 0;
        int lastK = getLastK(array,firstK,array.length-1,k);
        return lastK-firstK+1;
    }

    private int getFirstK(int[] arr, int start, int end,int k){
        if(start>end)
            return -1;
        int mid = (start+end)>>1;
        if(arr[mid]==k){
            if( mid == 0 ||arr[mid-1]!=k )
                return mid;
            else
                end = mid-1;
        }else if(arr[mid]<k){
            start = mid+1;
        }else{
            end = mid-1;
        }
        return getFirstK(arr,start,end,k);
    }

    private int getLastK(int[] arr, int start, int end,int k){
        if(start>end)
            return -1;
        int mid = (start+end)>>1;
        if(arr[mid]==k){
            if(mid==arr.length-1 || arr[mid+1]!=k )
                return mid;
            else
                start = mid+1;
        }else if(arr[mid]<k){
            start = mid+1;
        }else{
            end = mid-1;
        }
        return getLastK(arr,start,end,k);
    }
}
