package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Descriotion 字符串的排列
 * @Date 2022/5/7 0:08
 * @Created by shiyl
 */
public class StringPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0)
            return list;
        permutationCore(str.toCharArray(),0,list);
        Collections.sort(list);  //将list中的字符串排序
        return list;
    }

    private void permutationCore(char[] strArray,int index,ArrayList<String> list){
        if(index==strArray.length-1){
            if(!list.contains(String.valueOf(strArray)))  //判断是否有重复字符串
                list.add(String.valueOf(strArray));
        }else{
            for(int i=index;i<strArray.length;i++){
                char temp=strArray[index];
                strArray[index]=strArray[i];
                strArray[i]=temp;
                permutationCore(strArray,index+1,list);
                strArray[i]=strArray[index];
                strArray[index]=temp;
            }
        }
    }
}
