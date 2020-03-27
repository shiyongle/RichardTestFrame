package com.ydl.service.test_ydl_login_service.AccountFacede.testcase;

import com.ydl.service.test_ydl_login_service.AccountFacede.api.UpDateAccount;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * @Author: Richered
 * @Date: 2020/3/27 14:29
 * Description:
 */
public class TestUpDateAccount {
    @Test
    public void updateAccount(){
        UpDateAccount upDateAccount = new UpDateAccount();
        upDateAccount.GetUpDate(13091057, "richered", "shiyongle", "richered@yeah.net", "4637978572", "4637978572", "测试","2020-03-27T03:03:52.421Z", "2020-03-27T03:03:52.421Z").then().body("code", Matchers.equalTo("200"));
    }
}
