package com.crazyjava;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: Richered
 * @Date: 2020/7/2 10:34
 * Description: ProcessHandleshi java9新增的语法; 可作为性能测试监控参考
 */
public class ProcessHandleTest {
    public static void main(String[] args) throws Exception{
        Runtime rt = Runtime.getRuntime();

        Process p = rt.exec("notepad.exe");
        ProcessHandle ph = p.toHandle();
        System.out.println("进程是否运行：" + ph.isAlive());
        System.out.println("进程id：" + ph.pid());
        System.out.println("父进程：" + ph.parent());

        ProcessHandle.Info info = ph.info();
        System.out.println("进程命令："+ info.command());
        System.out.println("进程参数："+ info.arguments());
        System.out.println("进程启动时间："+ info.startInstant());
        System.out.println("进程累计运行时间："+ info.totalCpuDuration());

        //通过CompletableFuture在进程结束时运行某个任务
        CompletableFuture<ProcessHandle> cf = ph.onExit();
        cf.thenRunAsync(()->{
            System.out.println("程序退出");
        });
        Thread.sleep(5000);
    }
}
