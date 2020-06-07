package com.basics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author: Richered
 * @Date: 2020/5/20 0:09
 * @Description:
 */
public class TestStringBuilder {
    public static void main(String[] args) throws ParseException {
//        String str8 = "";
//
//        //获取系统剩余内存空间
//        long num1 = Runtime.getRuntime().freeMemory();
//        //获取系统当前时间
//        long time1 = System.currentTimeMillis();
//        for (int i = 0; i < 5000; i++){
//            str8 = str8 + i;
//        }
//        long num2 = Runtime.getRuntime().freeMemory();
//        long time2 = System.currentTimeMillis();
//
//        System.out.println("String占用内存大小：" + (num1 - num2));
//        System.out.println("String占用时间：" + (time2 - time1));

        //使用StringBuilder进行字符串拼接
        StringBuilder sb1 = new StringBuilder("");
        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 500; i++){
            sb1.append(i);
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuilder占用内存大小：" + (num3 - num4));
        System.out.println("StringBuilder占用时间：" + (time4 - time3));
        System.out.println("测试分支~~Local的分支");

        //把对象按照“格式字符串”的指定格式转换为字符串
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = df.format(new Date(4000));
        System.out.println(str);

        //把字符串按照“格式字符串指定的格式”转成相应的时间对象
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        Date date = df2.parse("1983年5月10日 10时45分59秒");
        System.out.println(date);
        //可以用常用的参数，例如D，可以获得本时间在所处年份的天数

        Calendar c4 = new GregorianCalendar();
        printCalendar(c4);
    }

    public static void printCalendar(Calendar c){
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) +1;
        int date = c.get(Calendar.DAY_OF_MONTH);
        int dayweek = c.get(Calendar.DAY_OF_WEEK) - 1;
        String dayweek2 = dayweek == 0 ? "日" : dayweek + "";
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        System.out.println(year + "年" + month + "月" + date + "日" + hour + "时"+ minute + "分" + second + "秒" + dayweek2 + "周");
    }
}
