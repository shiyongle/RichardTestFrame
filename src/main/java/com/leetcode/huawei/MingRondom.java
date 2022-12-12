package com.leetcode.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Descriotion 1到500之间的随机整数,将重复的去掉
 * @Date 2022/5/9 14:47
 * @Created by shiyl
 */
public class MingRondom {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){

            TreeSet<Integer> set=new TreeSet<Integer>();
            int n=sc.nextInt();
            if(n>0){
                for(int i=0;i<n;i++){
                    set.add(sc.nextInt());
                }
            }
            for(Integer i:set){
                System.out.println(i);
            }
        }
    }
}
