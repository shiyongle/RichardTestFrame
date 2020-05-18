package com.basics;

import java.util.Arrays;

/**
 * @Author: Richered
 * @Date: 2020/5/19 0:42
 * @Description: 冒泡排序
 */
public class TestBubbleSort {
    public static void main(String[] args) {

        int[] value = {3,1,2,6,5,4};
        int temp = 0;

        for (int i = 0; i < value.length - 1; i++){
            boolean flag = true;
            for (int j = 0; j < value.length -1 - i; j++){
                if (value[j] > value[j + 1]){
                    temp = value[j];
                    value[j] = value [j + 1];
                    value [j + 1] = temp;
                    flag = false;
                }
                System.out.println(Arrays.toString(value));
            }
            if (flag){
                System.out.println("结束！！！！");
                break;
            }
            System.out.println("###########################");
        }
    }
}
