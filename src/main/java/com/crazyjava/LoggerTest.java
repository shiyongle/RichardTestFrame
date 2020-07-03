package com.crazyjava;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: Richered
 * @Date: 2020/7/3 16:30
 * Description:
 */
public class LoggerTest {
    public static void main(String[] args) throws Exception {
        System.Logger logger = System.getLogger("fkjava");
        Logger.getLogger("fkjava").setLevel(Level.FINE);
        Logger.getLogger("fkjava").addHandler(new FileHandler("a.xml"));
        logger.log(System.Logger.Level.DEBUG, "debug信息");
        logger.log(System.Logger.Level.INFO, "INFO信息");
        logger.log(System.Logger.Level.ERROR, "ERROR信息");
    }
}
