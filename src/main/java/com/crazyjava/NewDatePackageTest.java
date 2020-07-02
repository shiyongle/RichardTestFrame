package com.crazyjava;

import net.sf.cglib.core.Local;

import java.time.*;

/**
 * @Author: Richered
 * @Date: 2020/7/2 21:35
 * @Description:
 */
public class NewDatePackageTest {
    public static void main(String[] args) {

        Clock clock = Clock.systemUTC();

        System.out.println("当前时刻为：" + clock.instant());

        //获取clock对应的毫秒数
        System.out.println(clock.millis());

        System.out.println(System.currentTimeMillis());

        Duration d = Duration.ofSeconds(6000);

        System.out.println("6000毫秒相当于：" + d.toMinutes() + "分");
        System.out.println("6000毫秒相当于：" + d.toHours() + "小时");
        System.out.println("6000毫秒相当于：" + d.toDays() + "天");

        Clock clock1 = Clock.offset(clock, d);
        System.out.println("当前时刻加6000秒为：" + clock1.instant());

        /**---------instant用法---------------**/
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加6000秒
        Instant instant1 = instant.plusSeconds(6000);
        System.out.println(instant1);

        Instant instant2 = Instant.parse("2014-02-23T10:12:35.342Z");
        System.out.println(instant2);

        //添加5小时4分钟
        Instant instant3 = instant2.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant3);

        //5天前
        Instant instant4 = instant3.minus(Duration.ofDays(5));
        System.out.println(instant4);

        /**-------LocalDate的用法-------**/
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        localDate = LocalDate.of(2013, Month.MAY, 21);
        System.out.println(localDate);

        /**-------LocalTime的用法-------**/
        LocalTime localTime = LocalTime.now();
        localTime = LocalTime.of(22, 33);
        System.out.println(localTime);

        localTime = LocalTime.ofSecondOfDay(5530);
        System.out.println(localTime);

        /**-------LocalDateTime的用法-------**/
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime future = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println("当前日期、时间的25小时3分之后：" + future);

        /**-------Year/YearMonth/MonthDay用法-------**/
        Year year = Year.now();
        System.out.println("当前年份" + year);

        year = year.plusYears(5);
        System.out.println("当前年份再过5年：" + year);

        YearMonth ym = year.atMonth(10);
        System.out.println("year年10月:" + ym);

        ym = ym.plusYears(5).minusMonths(3);
        System.out.println("year年10月再加5年，减3月：" + ym);

        MonthDay md = MonthDay.now();
        System.out.println("当前月日：" + md);

        MonthDay md2 = md.with(Month.MAY).withDayOfMonth(23);
        System.out.println("5月23日为：" + md2);
    }
}
