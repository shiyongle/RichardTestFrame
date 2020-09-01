package com.crazyjava;

import java.io.File;

/**
 * @Author: Richered
 * @Date: 2020/08/23 01:54
 * @Description:
 **/
public class FilenameFilterTest {

    public static void main(String[] args) {
        File file = new File(".");

        String[] nameList = file.list(((dir, name) -> name.endsWith(".java") || new File(name).isDirectory()));

        for (String name : nameList){
            System.out.println(name);
        }
    }
}
