package com.leetcode.algorithm;

/**
 * @Descriotion 丑数
 * @Date 2022/5/7 0:20
 * @Created by shiyl
 */
public class UglyNumbe {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        int[] UglyNumbers=new int[index];
        UglyNumbers[0]=1;
        int index2=0;
        int index3=0;
        int index5=0;
        for(int i=1;i<index;i++){
            UglyNumbers[i]=getMinimum(UglyNumbers[index2]*2,UglyNumbers[index3]*3,UglyNumbers[index5]*5);
            while(UglyNumbers[index2]*2<=UglyNumbers[i])
                index2++;
            while(UglyNumbers[index3]*3<=UglyNumbers[i])
                index3++;
            while(UglyNumbers[index5]*5<=UglyNumbers[i])
                index5++;
        }
        return UglyNumbers[index-1];
    }

    private int getMinimum(int a,int b,int c){
        if(a>b)
            a=b;
        if(a>c)
            a=c;
        return a;
    }

}
