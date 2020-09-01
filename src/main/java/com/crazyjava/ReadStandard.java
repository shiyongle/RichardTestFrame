package com.crazyjava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @Author: Richered
 * @Date: 2020/08/24 13:01
 * @Description:
 **/
public class ReadStandard {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in);
            PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))){
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                ps.println("键盘输入的内容是：" + sc.next());
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
