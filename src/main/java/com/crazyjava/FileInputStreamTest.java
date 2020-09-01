package com.crazyjava;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2020/08/23 01:58
 * @Description:
 **/
public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("FileInputStreamTest.java");

        byte[] bbuf = new byte[1024];

        int hashRead = 0;

        while ((hashRead = fis.read(bbuf)) > 0){
            System.out.println(new String(bbuf, 0, hashRead));
        }

        fis.close();
    }
}
