package com.leetcode.huawei;

import java.util.Scanner;

/**
 * DNA序列
 */
public class DNARelax {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int n = Integer.parseInt(sc.nextLine());
            double len = 0.0;
            String result = "";
            for(int i = 0 ; i < str.length() - n+1 ; i++){
                String aim = str.substring(i, i + n);
                String res = aim.replaceAll("[^CG]","");
                double cur = (double)res.length() / (double) n;
                if( cur > len){
                    len = cur;
                    result = aim;
                }
            }
            System.out.println(result);
        }
    }
}
