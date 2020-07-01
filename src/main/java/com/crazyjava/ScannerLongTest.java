package com.crazyjava;

import java.util.Scanner;

/**
 * @Author: Richered
 * @Date: 2020/7/1 21:54
 * @Description:
 */
public class ScannerLongTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()){
            System.out.println("键盘输入的内容是:" + sc.nextLong());
        }
    }
}
