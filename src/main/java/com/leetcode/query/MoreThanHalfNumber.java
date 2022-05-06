package com.leetcode.query;

/**
 * @Descriotion 数组中超过一半的数字
 * @Date 2022/5/7 0:09
 * @Created by shiyl
 */
public class MoreThanHalfNumber {
    boolean isInputInvalid = true;

    //方法一：partition方法
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null ||array.length<=0)
            return 0;
        int low=0;
        int high=array.length-1;
        int index=partition(array,low,high);
        while(index!=array.length>>1){
            if(index<array.length>>1){
                low=index+1;
                index=partition(array,low,high);
            }else{
                high=index-1;
                index=partition(array,low,high);
            }
        }
        //判断次数是否超过一半
        int num=array[index];
        int times=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==num){
                times++;
            }
        }
        if(times*2>array.length){
            isInputInvalid=false;
            return num;
        }
        return 0;
    }

    private int partition(int[] array,int low ,int high){
        int pivotKey=array[low];
        while(low<high){
            while(low<high &&  array[high]>=pivotKey)
                high--;
            int temp=array[low];
            array[low]=array[high];
            array[high]=temp;
            while(low<high && array[low]<=pivotKey)
                low++;
            temp=array[low];
            array[low]=array[high];
            array[high]=temp;
        }
        return low;
    }

    //方法二
    public int MoreThanHalfNum_Solution2(int [] array) {
        if(array==null || array.length<=0)
            return 0;
        int num=array[0];
        int count=1;
        for(int i=1;i<array.length;i++){
            if(count==0) {
                num=array[i];
                count++;
            }
            else if(array[i]==num)
                count++;
            else
                count--;
        }
        if(count>0){
            int times=0;
            for(int i=0;i<array.length;i++){
                if(array[i]==num){
                    times++;
                }
            }
            if(times*2>array.length){
                isInputInvalid=false;
                return num;
            }
        }
        return 0;
    }
}
