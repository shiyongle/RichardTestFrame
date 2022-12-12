package com.leetcode.huawei;

import java.util.Scanner;

/**
 * @Descriotion 进制转换
 * @Date 2022/5/9 14:47
 * @Created by shiyl
 */
public class BinaryConversion {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        }
    }
}
