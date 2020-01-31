package com.dubbo.impl;

import com.dubbo.inter.GreetingsService;

/**
 * @Author: Richered
 * @Date: 2020/1/31 16:10
 * @Description: 实现服务
 */
public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayHi(String name) {
        return "hi : " + name;
    }
}
