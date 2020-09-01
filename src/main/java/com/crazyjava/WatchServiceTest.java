package com.crazyjava;

import java.nio.file.*;

/**
 * @Author: Richered
 * @Date: 2020/09/01 19:20
 * @Description:
 **/
public class WatchServiceTest {

    public static void main(String[] args) throws Exception{
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get("C:/").register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        while (true){
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()){
                System.out.println(event.context() + "文件发生了"+ event.kind() + "事件 ");
            }
            boolean valid = key.reset();
            if (!valid){
                break;
            }
        }
    }
}
