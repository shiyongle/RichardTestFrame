package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/2 10:30
 * Description:
 */
public class ExecTest {
    public static void main(String[] args) throws Exception{
        Runtime rt = Runtime.getRuntime();
        rt.exec("notepad.exe");
    }
}
