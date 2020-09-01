package com.crazyjava;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @Author: Richered
 * @Date: 2020/09/01 19:12
 * @Description:
 **/
public class FileVistorTest {

    public static void main(String[] args) throws Exception{
        Files.walkFileTree(Paths.get("g:", "publish", "codes", "15"), new SimpleFileVisitor<Path>(){
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
                System.out.println("正在访问" + file + "文件");
                if (file.endsWith("FileVistorTest.java")){
                    System.out.println("已经找到目标文件");
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                System.out.println("正在访问" + dir + "路径");
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
