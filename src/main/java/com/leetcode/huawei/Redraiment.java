package com.leetcode.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Redraiment的走法
 */
public class Redraiment {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            scan.nextLine();
            String[] input1 = scan.nextLine().split(" ");
            int[] intArr = Arrays.stream(input1).mapToInt(Integer::parseInt).toArray();
            int[] k=new int[intArr.length];
            for(int j=1;j<intArr.length;j++){
                for(int i=0;i<j;i++){
                    if(intArr[i]<intArr[j]){
                        k[j]=Math.max(k[j],k[i]+1);
                    }
                }
            }
            Arrays.sort(k);
            System.out.println(k[k.length-1]+1);
        }
    }
}
