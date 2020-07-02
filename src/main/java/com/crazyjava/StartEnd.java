package com.crazyjava;

import javafx.css.Match;

import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Richered
 * @Date: 2020/7/2 22:40
 * @Description:
 */
public class StartEnd {
    public static void main(String[] args) {
        String regStr = "Java is very easy";
        System.out.println("目标字符串是:" + regStr);
        Matcher m = Pattern.compile("\\w+").matcher(regStr);
        while (m.find()){
            System.out.println(m.group() + "，字符串起始的位置:" + m.start() +"，其结束的位置:" + m.end());
        }
    }
}
