package com.crazyjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:54
 * @Description:
 */
public class AutoCloseTest {
    public static void main(String[] args) throws Exception{
        try (BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
             BufferedReader ps = new BufferedReader(new FileReader("a.txt"))){

            System.out.println(br.readLine());
//            ps.println();
        }
    }
}
