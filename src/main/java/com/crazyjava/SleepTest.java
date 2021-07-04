package com.crazyjava;

import java.util.Date;

/**
 * @Author: Richered
 * @Date: 2020/09/29 19:59
 * @Description:
 **/
public class SleepTest {

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i ++){
            System.out.println("当前时间:" + new Date());
            Thread.sleep(3000);
        }
    }
}
