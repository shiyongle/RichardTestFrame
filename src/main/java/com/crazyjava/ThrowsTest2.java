package com.crazyjava;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2020/07/20 19:35
 * @Description:
 **/
public class ThrowsTest2 {
    public static void main(String[] args) throws Exception{
        test();
    }

    public static void test() throws IOException{
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
