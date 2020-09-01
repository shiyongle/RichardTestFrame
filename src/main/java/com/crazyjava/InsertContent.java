package com.crazyjava;

import java.io.*;

/**
 * @Author: Richered
 * @Date: 2020/08/26 12:53
 * @Description:
 **/
public class InsertContent {

    public static void insert(String fileName, long ps, String insertContent) throws IOException{
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            FileOutputStream tmpOut = new FileOutputStream(tmp);
            FileInputStream tmpIn = new FileInputStream(tmp);) {

            raf.seek(ps);
            byte[] bbuf = new byte[64];
            int hasRead = 0;
            while ((hasRead = raf.read(bbuf)) > 0){
                tmpOut.write(bbuf, 0, hasRead);
            }
            raf.seek(ps);
            raf.write(insertContent.getBytes());
            while ((hasRead = tmpIn.read(bbuf)) > 0){
                raf.write(bbuf, 0, hasRead);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        insert("InsertContent.java", 45, "插入的内容");
    }
}
