package com.crazyjava;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 * @Author: Richered
 * @Date: 2020/7/3 16:40
 * Description:
 */
public class LoggerI18N {
    public static void main(String[] args) throws Exception{
        ResourceBundle rb = ResourceBundle.getBundle("logMess", Locale.getDefault(Locale.Category.FORMAT));

        System.Logger logger = System.getLogger("fkjava", rb);

        Logger.getLogger("fkjava").addHandler(new FileHandler("a.xml"));

        logger.log(System.Logger.Level.DEBUG, "debug信息");
        logger.log(System.Logger.Level.INFO, "INFO信息");
        logger.log(System.Logger.Level.ERROR, "ERROR信息");
    }
}
