package com.crazyjava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Richered
 * @Date: 2020/7/3 17:38
 * Description:
 */
public class DateTimeFormatterParse {
    public static void main(String[] args) {
        String str1 = "2014==04==12 01时06分09秒";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");

        LocalDateTime dt1 = LocalDateTime.parse(str1, formatter);

        System.out.println(dt1);

        String str2 = "2014$$$4月$$$13 20小时";

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyy$$$MM$$$dd HH小时");

        LocalDateTime dt2 = LocalDateTime.parse(str2, formatter1);

        System.out.println(dt2);
    }
}
