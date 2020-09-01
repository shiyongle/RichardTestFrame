package com.crazyjava;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2020/08/23 02:11
 * @Description:
 **/
public class FileWriteTest {

    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("poem.txt");

            fw.write("1");
            fw.write("2");
            fw.write("3");
            fw.write("4");
            fw.write("5");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
