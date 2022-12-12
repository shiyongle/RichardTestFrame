package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 密码截取
 */
public class InterceptPassWord {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();
        if(n<2) {System.out.println(n);return;}

        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++) dp[i][i]=true;

        int j,ans=0;
        for(int L=2;L<=n;L++){
            for(int i=0;i<n+1-L;i++){
                j=L+i-1;

                if(s.charAt(i)==s.charAt(j))
                    if(L<=3){
                        dp[i][j]=true;
                    }else dp[i][j]=dp[i+1][j-1];

                else dp[i][j]=false;

                if(dp[i][j]){
                    ans=Math.max(L,ans);
                }
            }

        }

        System.out.println(ans);
    }
}
