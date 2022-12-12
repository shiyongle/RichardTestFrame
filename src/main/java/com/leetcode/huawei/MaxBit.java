package com.leetcode.huawei;

import java.util.Scanner;

/**
 * 最大连续bit数
 */
public class MaxBit {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            // 转二进制
            String binaryStr = Integer.toBinaryString(num);
            // 用0 分割
            String[] strArray = binaryStr.split("0");
            // 字符串长度
            int result = 0;
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i].length() > result) {
                    result = strArray[i].length();
                }
            }
            System.out.println(result);
        }
    }
}
