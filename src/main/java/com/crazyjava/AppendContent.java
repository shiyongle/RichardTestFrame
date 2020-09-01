package com.crazyjava;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author: Richered
 * @Date: 2020/08/26 12:51
 * @Description:
 **/
public class AppendContent {

    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("out.txt", "rw");
            raf.seek(raf.length());
            raf.write("追加的内容!\r\n".getBytes());
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
