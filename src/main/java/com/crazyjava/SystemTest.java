package com.crazyjava;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2020/7/1 22:05
 * @Description:
 */
public class SystemTest {
    public static void main(String[] args) throws Exception{
        //获取所有的环境变量
        Map<String, String> env = System.getenv();
        for (String name: env.keySet()){
            System.out.println(name + "--->" +env.get(name));
        }
        //获取指定的环境变量
        System.out.println(System.getenv("JAVA_HOME"));

        //获取所有的系统属性
        Properties props = System.getProperties();

        //将所有的系统属性保存在该txt文件中
        props.store(new FileOutputStream("props.txt"), "System Properties");

        //输出系统的特定属性
        System.out.println(System.getProperty("os.name"));
    }
}
