package com.ydl.service.test_ydl_login_service.AccountFacede.testcase;

import com.ydl.service.test_ydl_login_service.AccountFacede.api.UnBindAccount;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * @Author: Richered
 * @Date: 2020/3/27 14:09
 * Description:
 */
public class TestUnBindAccount {
    @Test
    public void unBindAccount(){
        UnBindAccount unBindAccount = new UnBindAccount();
        unBindAccount.GetUnBind(13091057, "o1Fn5sgb8unq5JotNiTXumJDdESw","windows").then().body("code", Matchers.equalTo("200"));
    }
}
