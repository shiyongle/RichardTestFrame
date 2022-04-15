package com.weiyi.api.testcase;

import com.weiyi.api.increment.VipQuery;
import com.weiyi.service.VipService;
import org.apache.dubbo.config.annotation.Service;
import org.junit.Test;
import org.springframework.stereotype.Component;

import static org.hamcrest.Matchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2022/2/18 16:11
 * @Description
 */
@Component
@Service(interfaceClass = VipService.class)
public class TestVipQuery implements VipService {

    static VipQuery vipQuery = new VipQuery();

    /**
     * 该用户无此会员产品
     */
    @Test
    public void testNoVipBySku(){
        vipQuery.isVipBySku("E404552SUNWIS").then().body("data", equalTo(false));
    }
    /**
     * 该用户有此会员产品
     */
    @Test
    public void testIsVipBySku(){
        vipQuery.isVipBySku("E404557SPNEIS").then().body("data", equalTo(true));
    }

    /**
     * 引流会员发送验证码
     */
    @Test
    public void testSendCode(){
        vipQuery.sendMobile("13210001000").then().body("data", equalTo(true));
    }

    /**
     * 根据商品规格免费领取会员
     * @return
     */
    @Test
    public void testFreeReceive(){
        vipQuery.freeReceive("会员倒霉蛋1号","13210001000", "E404552SUNWIS", "111111");
    }

    /**
     * 根据sku获取对应的推荐商品
     */
    @Test
    public void testRecommendSku(){
        vipQuery.recommendSku("E220505TOOGHM");
    }
}
