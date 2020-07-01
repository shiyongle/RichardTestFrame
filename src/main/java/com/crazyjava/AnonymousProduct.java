package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/7/1 13:26
 * Description:
 */
public class AnonymousProduct implements ProductOne {
    @Override
    public double getPrice() {
        return 123.4;
    }

    @Override
    public String getName() {
        return "超级牛逼无敌显卡";
    }
}
