package com.ydl.service.test_ydl_login_service.AccountFacede.testcase;

import com.ydl.service.test_ydl_login_service.AccountFacede.api.UpDatePhone;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 13:32
 * Description:
 */
public class TestUpDatePhone {

    @Test
    public void update(){
        UpDatePhone upDatePhone = new UpDatePhone();
        upDatePhone.modify(13091057, "13216101995").then().body("msg", equalTo("成功"));
    }
}
