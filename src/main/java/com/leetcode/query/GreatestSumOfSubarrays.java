package com.leetcode.query;

/**
 * @Descriotion 连续字数组的最大和
 * @Date 2022/5/7 0:13
 * @Created by shiyl
 */
public class GreatestSumOfSubarrays {
    boolean InvalidInput = false;
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null || array.length<=0){
            InvalidInput = true;
            return 0;
        }
        InvalidInput = false;
        int sum=array[0];
        int maxSum=array[0];
        for(int i=1;i<array.length;i++){
            if(sum<0)
                sum=array[i];
            else
                sum+=array[i];
            if(sum>maxSum)
                maxSum=sum;
        }
        return maxSum;
    }
}
