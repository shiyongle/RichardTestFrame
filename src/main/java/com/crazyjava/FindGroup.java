package com.crazyjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Richered
 * @Date: 2020/7/2 22:31
 * @Description:正则表达式
 */
public class FindGroup {
    public static void main(String[] args) {
        String sta = "hello, java!";
        System.out.println(sta.replaceFirst("\\w*", "&"));
        System.out.println(sta.replaceFirst("\\w*?", "&"));

        String str = "我想求购一本《疯狂Java讲义》， 尽快联系我13500006666"  +
                "交朋友，电话号码是13611125565" +
                "出售二手电脑，联系方式15899903312";

        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
