package com.leetcode.huawei;


import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Descriotion 合并表记录
 * @Date 2022/5/9 14:47
 * @Created by shiyl
 */
public class ConsolidatedStatement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            for (int i = 0; i<n; ++i){
                int a = sc.nextInt();
                int b = sc.nextInt();
                map.put(a, map.getOrDefault(a, 0) + b);
            }
        }
        for (Integer i : map.keySet()){
            System.out.println(i + " "+ map.get(i));
        }
    }
}
