package com.leetcode.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 字符串排序
 */
public class StringSort {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = br.readLine();
        }
        br.close();

        Arrays.sort(ss);

        for(int i = 0; i < n; i++) {
            System.out.println(ss[i]);
        }
    }
}
