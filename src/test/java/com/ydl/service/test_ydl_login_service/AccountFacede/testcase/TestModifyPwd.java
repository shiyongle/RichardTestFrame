package com.ydl.service.test_ydl_login_service.AccountFacede.testcase;

import com.ydl.service.test_ydl_login_service.AccountFacede.api.ModifyPwd;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:29
 * Description:
 */
public class TestModifyPwd {
    @Test
    public void TestModify(){
        ModifyPwd newpwd = new ModifyPwd();
        newpwd.modify(13091057, "123456").then().body("msg", equalTo("成功"));
    }
}
