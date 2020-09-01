package com.crazyjava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @Author: Richered
 * @Date: 2020/08/23 02:13
 * @Description:
 **/
public class PrintSteamTest {

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("test.txt");
            PrintStream ps = new PrintStream(fos);
            ps.println("普通字符串");
            ps.println(new PrintSteamTest());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
