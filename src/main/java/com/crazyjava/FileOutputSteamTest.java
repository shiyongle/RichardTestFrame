package com.crazyjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2020/08/23 02:08
 * @Description:
 **/
public class FileOutputSteamTest {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("FileOutputSteamTest.java");
            FileOutputStream fos = new FileOutputStream("newfile.txt");
            byte[] bbuf = new byte[32];
            int hashRead = 0;
            while ((hashRead = fis.read(bbuf)) > 0){
                fos.write(bbuf, 0, hashRead);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
