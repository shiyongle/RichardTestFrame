package com.crazyjava;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2020/08/23 01:48
 * @Description:
 **/
public class FileTest {

    public static void main(String[] args) throws IOException {

        File file = new File(".");

        System.out.println(file.getName());

        System.out.println(file.getParent());

        System.out.println(file.getAbsoluteFile());

        System.out.println(file.getAbsoluteFile().getParent());

        File tmpFile = File.createTempFile("aaa", ".txt", file);

        tmpFile.deleteOnExit();

        File newFile = new File(System.currentTimeMillis() + "");

        System.out.println("newfile对象是否存在:" + newFile.exists());

        newFile.createNewFile();

        newFile.mkdir();

        String[] fileList = file.list();

        for (String fileName : fileList){
            System.out.println(fileName);
        }

        File[] roots = File.listRoots();

        System.out.println("------系统所有根路径如下-------");

        for (File root : roots){
            System.out.println(root);
        }
    }
}
