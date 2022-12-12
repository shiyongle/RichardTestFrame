package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 找出字符串中第一个只出现一次的字粗
 */
public class NowOneChar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            //设置信号量
            int signal = 0;
            //读取输入内容
            String str = sc.nextLine();
            //遍历输入内容
            for(int i = 0; i < str.length(); i++){
                //判断每个字符是否出现第二次，如果存在，设置信号量signal为1；
                if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){
                    System.out.print(str.charAt(i));
                    signal = 1;
                    break;
                }
            }
            //如果信号量为零，证明不存在重复字符
            if(signal == 0){
                System.out.println(-1);
            }
            //每读取一行输出一个回车
            System.out.println();
        }
    }
}
