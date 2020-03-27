package com.ydl.service.cps_center_service.CpsDistributorAccessFacade.testcase;

import com.ydl.service.cps_center_service.CpsDistributorAccessFacade.api.AfterLogin;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:45
 * Description:
 */
public class TestAfterLogin {
    @Test
    public void afterlogin(){
        AfterLogin afterLogin = new AfterLogin();
        afterLogin.get(112).then().body("code",  equalTo("200"));
    }
}
