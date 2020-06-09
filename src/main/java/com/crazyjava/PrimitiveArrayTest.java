package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/10 0:17
 * @Description:
 */
public class PrimitiveArrayTest {
    public static void main(String[] args) {
        int[] iArr;
        iArr = new int[5];
        for (int i = 0; i < iArr.length; i ++){
            iArr[i] = i + 10;
        }
    }
}
