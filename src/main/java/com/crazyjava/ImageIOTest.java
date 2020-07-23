package com.crazyjava;

import javax.imageio.ImageIO;

/**
 * @Author: Richered
 * @Date: 2020/07/23 12:40
 * @Description:
 **/
public class ImageIOTest {
    public static void main(String[] args) {
        String[] readFormat = ImageIO.getReaderFormatNames();
        System.out.println("----Image能读的所有图形的文件格式----");
        for (String tmp : readFormat){
            System.out.println( tmp);
        }

        String[] writeFormat = ImageIO.getWriterFormatNames();
        System.out.println("----Image能写的所有文件的图形格式----");
        for (String tmp : writeFormat){
            System.out.println(tmp);
        }
    }
}
