package com.crazyjava;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @Author: Richered
 * @Date: 2020/7/3 17:11
 * Description:
 */
public class DateFormatTest {
    public static void main(String[] args) throws ParseException {
        Date dt = new Date();

        Locale[] locales = {Locale.CHINA, Locale.US};

        DateFormat[] df = new DateFormat[16];

        for (int i = 0; i < locales.length; i++){
            df[i * 8] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
            df[i * 8 + 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, locales[i]);
            df[i * 8 + 2] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
            df[i * 8 + 3] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
            df[i * 8 + 4] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
            df[i * 8 + 5] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
            df[i * 8 + 6] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
        }


        for (int i = 0; i < locales.length; i ++){
            String tip = i == 0 ? "----中国的日期格式----" : "----美国的格式----";
            System.out.println(tip);
            System.out.println("SHORT格式的日期格式:" + df[i * 8].format(dt));
            System.out.println("MEDIUM格式的日期格式:" + df[i * 8 + 1].format(dt));
            System.out.println("LONG格式的日期格式:" + df[i * 8 + 2].format(dt));
            System.out.println("FULL格式的日期格式:" + df[i * 8 + 3].format(dt));
            System.out.println("SHORT格式的日期格式:" + df[i * 8 + 4].format(dt));
            System.out.println("LONG格式的日期格式:" + df[i * 8 + 5].format(dt));
            System.out.println("FULL格式的日期格式:" + df[i * 8 + 6].format(dt));
        }
    }
}
