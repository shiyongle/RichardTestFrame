package com.weiyi.service;

import com.guahao.convention.data.domain.Result;
import org.springframework.stereotype.Service;

/**
 * @Author: Richered
 * @Date: 2022/3/19 17:51
 * @Description 会员用例接口
 */
@Service
public interface VipService {

    /**
     * 该用户无此会员产品
     */
    void testNoVipBySku();

    /**
     * 该用户有此会员产品
     */
    void testIsVipBySku();

    /**
     * 引流会员发送验证码
     */
    void testSendCode();

    /**
     * 根据商品规格免费领取会员
     * @return
     */
    void testFreeReceive();

    /**
     * 根据sku获取对应的推荐商品
     */
    void testRecommendSku();
}
