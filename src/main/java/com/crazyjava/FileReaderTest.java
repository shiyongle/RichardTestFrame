package com.crazyjava;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2020/08/23 02:00
 * @Description:
 **/
public class FileReaderTest {

    public static void main(String[] args) throws IOException {

        try{
            FileReader fr = new FileReader("FileReaderTest.java");
            char[] cbuf = new char[32];

            int hasRead = 0;

            while((hasRead = fr.read(cbuf)) > 0){
                System.out.println(new String(cbuf, 0, hasRead));
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }



    }
}
