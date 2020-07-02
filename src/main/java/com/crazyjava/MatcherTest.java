package com.crazyjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Richered
 * @Date: 2020/7/2 22:43
 * @Description:
 */
public class MatcherTest {
    public static void main(String[] args) {
        String[] mails = {
                "kongyeeku@163.com",
                "kongyeeku@gmail.com",
                "ligang@crazyit.com",
                "wawa@abc.xx"
        };

        String mainRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern mailPattern = Pattern.compile(mainRegEx);
        Matcher matcher = null;
        for (String mail: mails){
            if (matcher == null){
                matcher = mailPattern.matcher(mail);
            }else {
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮件地址！";
            System.out.println(result);
        }
    }
}
