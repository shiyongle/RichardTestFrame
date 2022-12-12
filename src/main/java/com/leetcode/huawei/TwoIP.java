package com.leetcode.huawei;

/**
 * 判断两个ip是否属于同一个子网
 */
import java.io.*;
import java.util.*;

public class TwoIP{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String mask = sc.nextLine();
            String ip1 = sc.nextLine();
            String ip2 = sc.nextLine();
            check( mask,  ip1,  ip2);
        }
    }
    public static void check(String mask, String ip1, String ip2){
        boolean codeMask = checkFormat(mask);
        boolean codeIp1 = checkFormatIP(ip1);
        boolean codeIp2 = checkFormatIP(ip2);
        if(!codeMask || !codeIp1 || !codeIp2){
            System.out.println(1);
            return;
        }
        long maskNum = ip2num(mask);
        long ip1Num = ip2num(ip1);
        long ip2Num = ip2num(ip2);
        if((maskNum & ip1Num) == (maskNum & ip2Num)){
            System.out.println(0);
            return;
        }
        System.out.println(2);
        return;
    }

    public static boolean checkFormat(String mask){
        String[] ss = mask.split("\\.");
        int[] m = new int[ss.length];
        for(int i = 0; i < ss.length; ++i){
            m[i] = Integer.parseInt(ss[i]);
        }
        return m[0] >= 0 && m[0] <= 255 &&
                m[1] >= 0 && m[1] <= 255 &&
                m[2] >= 0 && m[2] <= 255 &&
                m[3] >= 0 && m[3] <= 255 &&
                m[0] >= m[1] && m[1] >= m[2] && m[2] >= m[3];
    }

    public static boolean checkFormatIP(String str){
        String[] ss = str.split("\\.");
        for(String s : ss){
            int num = Integer.parseInt(s);
            if(!(num >= 0 && num <= 255)){
                return false;
            }
        }
        return true;
    }

    public static long ip2num(String str){
        String[] ss = str.split("\\.");

        long sum = 0L;
        long mul = 1L;
        for(int i = ss.length - 1; i >= 0; i--){
            long seg = Long.parseLong(ss[i]);
            sum += seg * mul;
            mul *= 256;
        }
        return sum;
    }
}
