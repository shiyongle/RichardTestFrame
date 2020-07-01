package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 17:38
 * Description:
 */
public class FinalizeTest {
    private static FinalizeTest ft = null;

    public void info(){
        System.out.println("测试资源清理的finalize方法");
    }

    public static void main(String[] args) throws Exception{
        //创建FinalizeTest对象立即进入可恢复状态
        new FinalizeTest();
        //通知系统进行垃圾回收
//        Runtime.getRuntime().runFinalization();       强制垃圾回收机制调用
        System.gc();
        System.runFinalization();
        ft.info();
    }

    public void finalize(){
        ft = this;
    }
}
