package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/9 16:44
 * Description:
 */
public class StringSwitchTest {
    public static void main(String[] args) {
        String season = "夏天";
        switch (season){
            case "春天":
                System.out.println("春暖花开");
                break;
            case "夏天":
                System.out.println("夏日炎炎");
                break;
            case "秋天":
                System.out.println("秋高气爽");
                break;
            case "冬天":
                System.out.println("冰风万里");
                break;
            default:
                System.out.println("季节输入错误");
        }
    }
}
