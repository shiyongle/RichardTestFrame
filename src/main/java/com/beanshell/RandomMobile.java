package com.beanshell;

import java.util.Random;

/**
 * @Author: Richered
 * @Date: 2022/3/15 22:18
 * @Description 随机手机号码 参见博客：Beanshell范例
 */
public class RandomMobile {

    public void BeanShell() {
        String phone = "1";
        String number = System.currentTimeMillis() + "";

        for(int i = 0;i<100;i++){
            int second = new Random().nextInt(10);
            if (second == 3 || second == 4 || second == 5 || second == 7 || second == 8) {
                phone = phone + second;
                break;
            }
        }

        if("13".equals(phone)||"18".equals(phone))
        {
            int third = new Random().nextInt(10);
            phone = phone + third;
        }

        if("14".equals(phone))
        {
            int[] arr = { 5, 7, 9 };
            phone = phone + arr[new Random().nextInt(3)];
        }

        if("15".equals(phone))
        {
            int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            phone = phone + arr[new Random().nextInt(arr.length)];
        }

        if("17".equals(phone))
        {
            int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
            phone = phone + arr[new Random().nextInt(arr.length)];
        }

        phone=phone+number.substring(5,5+8);
        System.out.println(phone);

    }
    public static void main(String[] args) {
        RandomMobile test = new RandomMobile();
        test.BeanShell();
    }
}
