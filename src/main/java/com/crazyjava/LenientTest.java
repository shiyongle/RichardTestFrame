package com.crazyjava;

import java.util.Calendar;

/**
 * @Author: Richered
 * @Date: 2020/7/2 16:11
 * Description:
 */
public class LenientTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.MONTH, 13);

        System.out.println(cal.getTime());

        cal.setLenient(false);

        cal.set(Calendar.MONTH, 13);

        System.out.println(cal.getTime());
    }
}
