package com.crazyjava;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2020/07/20 19:34
 * @Description:
 **/
public class ThrowsTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
