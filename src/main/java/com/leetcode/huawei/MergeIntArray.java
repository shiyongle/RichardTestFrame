package com.leetcode.huawei;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 整型数组合并
 */
public class MergeIntArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Set<Long> set = new TreeSet<>();
            //接收第一个整形数组大小
            int size1 = sc.nextInt();
            for (int i = 0; i < size1; i++) {
                set.add(sc.nextLong()); //将该组的整数按数组大小循环添加进 set
            }
            //接收第一个整形数组大小
            int size2 = sc.nextInt();
            for (int i = 0; i < size2; i++) {
                set.add(sc.nextLong());
            }
            //遍历输出
            for (long n : set) {
                System.out.print(n);
            }
      /*
      注意：测试案例会以 两个整形数组 为一组测试用例， 并可能输入多组
      要记得组与组的结果之间换行
      */
            System.out.println();
        }
    }
}
