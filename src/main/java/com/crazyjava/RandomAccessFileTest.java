package com.crazyjava;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author: Richered
 * @Date: 2020/08/26 12:46
 * @Description:
 **/
public class RandomAccessFileTest {

    public static void main(String[] args) {

        try {
            RandomAccessFile ref = new RandomAccessFile("RandomAccessFileTest.java", "r");

            System.out.println("RandomAccessFile的文件指针的初始位置：" + ref.getFilePointer());

            ref.seek(300);

            byte[] bbuf = new byte[1024];

            int hasRead = 0;

            while ((hasRead = ref.read(bbuf)) > 0){
                System.out.println(new String(bbuf, 0, hasRead));
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
