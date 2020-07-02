package com.crazyjava;

import java.util.Calendar;

import static java.util.Calendar.YEAR;
import static java.util.Calendar.MONTH;
/**
 * @Author: Richered
 * @Date: 2020/7/2 15:58
 * Description:
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        //年
        System.out.println(c.get(YEAR));

        System.out.println(c.get(Calendar.MONTH));

        System.out.println(c.get(Calendar.DATE));

        c.set(2003, 10, 23, 12, 32, 23);

        System.out.println(c.getTime());

        c.add(YEAR, -1);

        System.out.println(c.getTime());

        c.roll(MONTH, -8);

        System.out.println(c.getTime());
    }
}
