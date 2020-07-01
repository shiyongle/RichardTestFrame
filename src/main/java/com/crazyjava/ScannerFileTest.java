package com.crazyjava;

import java.io.File;
import java.util.Scanner;

/**
 * @Author: Richered
 * @Date: 2020/7/1 21:57
 * @Description:
 */
public class ScannerFileTest {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("ScannerFileTest.java"));
        System.out.println("ScannerFileTest.java文件的内容如下：");
        while (sc.hasNextLine()){
            System.out.println(sc.hasNextLine());
        }
    }
}
