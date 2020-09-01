package com.crazyjava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author: Richered
 * @Date: 2020/08/24 12:53
 * @Description:
 **/
public class RedirectIn {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("RedirectIn.java");
            System.setIn(fis);
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                System.out.println("键盘输入的内容是：" + sc.next());
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
