package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 16:45
 * Description:
 */
public class EnumTest {
    public void judge(SeasonEnum s){
        switch (s){
            case SPRING:
                System.out.println("春暖花开，正好踏青");
                break;
            case SUMMER:
                System.out.println("夏日炎炎，正好游泳");
                break;
            case FALL:
                System.out.println("秋高气爽，粮食收获");
                break;
            case WINTER:
                System.out.println("冰风万里，雪花飘飘");
                break;
        }
    }

    public static void main(String[] args) {
        for (SeasonEnum s: SeasonEnum.values()){
            System.out.println(s);
        }
        new EnumTest().judge(SeasonEnum.SPRING);
    }
}
