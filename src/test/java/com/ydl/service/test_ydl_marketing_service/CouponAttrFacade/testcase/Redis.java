package com.ydl.service.test_ydl_marketing_service.CouponAttrFacade.testcase;

import com.ydl.service.test_ydl_marketing_service.CouponAttrFacade.api.TestRedis;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 16:32
 * Description:
 */
public class Redis {
    @Test
    public void testRedis(){
        TestRedis testRedis = new TestRedis();
        testRedis.get("test").then().body("code",  equalTo("200"));
    }
}
