package com.crazyjava;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @Author: Richered
 * @Date: 2020/7/3 17:30
 * Description:
 */
public class NewFormatterTest {
    public static void main(String[] args) {
        DateTimeFormatter[] formatter = new DateTimeFormatter[]{
                //直接使用常量创建DateTimeFormatter格式器
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,

                //使用本地化的不同风格来创建DateTimeFormatter格式器
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
                DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG),

                //根据模式字符串来创建DateTimeFormatter格式器
                DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss")
        };

        LocalDateTime date = LocalDateTime.now();

        for(int i = 0; i < formatter.length; i ++){
            System.out.println(date.format(formatter[i]));
            System.out.println(formatter[i].format(date));
        }
    }
}
