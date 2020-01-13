package com.service.user.testcase;

import com.service.user.api.UserApi;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/1/13 22:01
 * @Description: 测试数据驱动类
 */
public class TestUserApi {
    @Test
    public void get(){
        UserApi user = new UserApi();
        user.get("123456789").then().body("errcode", equalTo(0));
    }
}
