package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/7 23:07
 * @Description: 疯狂java讲义-字符
 */
public class CharTest {
    public static void main(String[] args) {
        //直接指定单个字符作为字符串
        char aChar = 'a';

        //使用转义字符作为字符值
        char enterChar = '\r';

        //使用Unicode编码来指定字符值
        char ch = '\u9999';
        System.out.println(ch);     //将输出一个“香”字

        char zhong = '疯';
        //将char变量当成int类型变量使用
        int zhongValue = zhong;
        System.out.println(zhongValue);

        //直接把一个0~65535范围内的int整数赋给一个char变量
        char c = 97;
        System.out.println(c);
    }
}
