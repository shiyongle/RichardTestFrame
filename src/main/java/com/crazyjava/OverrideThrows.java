package com.crazyjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Richered
 * @Date: 2020/07/20 19:37
 * @Description:
 **/
public class OverrideThrows {
    public void test() throws IOException{
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
