package com.weiyi.controller;

import com.guahao.convention.data.domain.Result;
import com.weiyi.service.VipService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Richered
 * @Date: 2022/3/19 17:55
 * @Description
 */
@RestController("/vip")
public class VipCaseController {

    @Resource
    VipService vipService;

    @RequestMapping("/runCase")
    public void runCase(){
        vipService.testNoVipBySku();
        vipService.testIsVipBySku();
        vipService.testSendCode();
        vipService.testFreeReceive();
        vipService.testRecommendSku();
    }
}
