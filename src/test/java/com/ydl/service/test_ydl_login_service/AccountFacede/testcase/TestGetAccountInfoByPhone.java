package com.ydl.service.test_ydl_login_service.AccountFacede.testcase;

import com.ydl.service.test_ydl_login_service.AccountFacede.api.GetAccountInfoByPhone;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:21
 * Description:
 */
public class TestGetAccountInfoByPhone {
    @Test
    public void byPhone(){
        GetAccountInfoByPhone phone = new GetAccountInfoByPhone();
        phone.getInfoByPhone("13216101995").then().body("msg", equalTo("成功"));
    }
}
