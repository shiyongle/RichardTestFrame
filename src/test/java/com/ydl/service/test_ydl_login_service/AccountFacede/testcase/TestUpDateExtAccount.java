package com.ydl.service.test_ydl_login_service.AccountFacede.testcase;

import com.ydl.service.test_ydl_login_service.AccountFacede.api.UpDateExtAccount;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 15:31
 * Description:
 */
public class TestUpDateExtAccount {
    @Test
    public void upDateExt(){
        UpDateExtAccount upDateExtAccount = new UpDateExtAccount();
        upDateExtAccount.GetUpDateExt(13091057, 1, 1).then().body("code",  equalTo("300004"));
    }
}
