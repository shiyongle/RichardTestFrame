package com.crazyjava;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @Author: Richered
 * @Date: 2020/08/24 12:51
 * @Description:
 **/
public class RedirectOut {

    public static void main(String[] args) {
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("out.txt"));
            System.setOut(ps);
            System.out.println("普通字符串");
            System.out.println(new RedirectOut());
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
