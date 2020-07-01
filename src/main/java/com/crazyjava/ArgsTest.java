package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 21:45
 * @Description:
 */
public class ArgsTest {
    public static void main(String[] args) {
        System.out.println(args.length);
        for (String arg : args){
            System.out.println(arg);
        }
    }
}
