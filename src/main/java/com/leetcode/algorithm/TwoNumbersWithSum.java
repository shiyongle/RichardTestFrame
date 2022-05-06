package com.leetcode.algorithm;

import java.util.ArrayList;

/**
 * @Descriotion 和为s的两个数字
 * @Date 2022/5/7 0:30
 * @Created by shiyl
 */
public class TwoNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array==null || array.length<=0)
            return list;
        int low=0;
        int high=array.length-1;
        while(low<high){
            if(array[low]+array[high]==sum){
                list.add(array[low]);
                list.add(array[high]);
                break;
            }else if(array[low]+array[high]<sum)
                low++;
            else
                high--;
        }
        return list;
    }
}
