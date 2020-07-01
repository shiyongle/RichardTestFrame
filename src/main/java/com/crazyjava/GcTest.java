package com.crazyjava;

import org.omg.SendingContext.RunTime;

/**
 * @Author: Richered
 * @Date: 2020/7/1 17:35
 * Description:
 */
public class GcTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            new GcTest();
            /**
             * 强制系统垃圾回收的两种方式
             */
//            System.gc();
            Runtime.getRuntime().gc();
        }
    }

    public void finalize(){
        System.out.println("系统正在清理GCTest对象资源");
    }
}
