package com.leetcode.algorithm;

/**
 * @Descriotion 字符流中第一个只出现一次的字符
 * @Date 2022/5/7 0:22
 * @Created by shiyl
 */
public class FirstCharacterInStream {
    private int index;
    private int[] occurence;

    public FirstCharacterInStream() {  //在构造函数中初始化成员变量
        index=0;
        occurence = new int[256];
        for(int i=0;i<256;i++) {
            occurence[i]=-1;
        }
    }

    public void insert(char ch) {
        if(occurence[(int)ch]==-1) {
            occurence[(int)ch]=index;   //第一次出现
        }else if(occurence[(int)ch]>=0) {
            occurence[(int)ch]=-2;   //已经出现过了
        }
        index++;
    }

    public char getFirst() {
        int minIndex=Integer.MAX_VALUE;  //最大的integer
        char ch='#';
        for(int i=0;i<256;i++) {
            if(occurence[i]>=0 && occurence[i]<minIndex) {
                ch = (char) i;
                minIndex=occurence[i];
            }
        }
        return ch;
    }
}
