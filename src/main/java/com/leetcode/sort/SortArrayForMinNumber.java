package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Descriotion 把数组拍成最小的数
 * @Date 2022/5/7 0:16
 * @Created by shiyl
 */
public class SortArrayForMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length<=0)
            return "";
        ArrayList<String> list = new ArrayList<String>();
        for(int number:numbers)
            list.add(String.valueOf(number));
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                String a=s1+s2;
                String b=s2+s1;
                return a.compareTo(b);
            }
        });
        StringBuilder sb= new StringBuilder();
        for(String str:list)
            sb.append(str);
        return sb.toString();
    }
}
