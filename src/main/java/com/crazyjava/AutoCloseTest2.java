package com.crazyjava;

import java.io.*;
import java.nio.Buffer;

/**
 * @Author: Richered
 * @Date: 2020/7/19 23:57
 * @Description:
 */
public class AutoCloseTest2 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
        PrintStream ps = new PrintStream(new FileOutputStream("a.txt"));
        try (br ; ps){
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }
    }
}
