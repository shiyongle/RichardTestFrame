package com.crazyjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2020/7/8 22:58
 * @Description:
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception{
        Properties props = new Properties();
        props.setProperty("username", "richered");
        props.setProperty("password", "123456");

        props.store(new FileOutputStream("a.ini"), "comment line");

        Properties props2 = new Properties();
        props2.setProperty("gender", "male");
        props2.load(new FileInputStream("a.ini"));
        System.out.println(props2);
    }
}
