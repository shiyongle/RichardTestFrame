package com.leetcode.huawei;

import java.util.Scanner;

/**
 * @Descriotion 计算出某字符出现的次数，不区分大小写
 * @Date 2022/5/9 14:47
 * @Created by shiyl
 */
public class CalculationFrequency {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input1= s.nextLine();
        String input2 = s.nextLine();
        String split3 = input1.toUpperCase().replaceAll(input2.toUpperCase(),
                "");
        System.out.println(input1.length() - split3.length());
    }
}
