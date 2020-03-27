package com.ydl.service.test_ydl_login_service.AccountFacede.testcase;

import com.ydl.service.test_ydl_login_service.AccountFacede.api.BindAccount;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 13:52
 * Description:
 */
public class TestBindAccount {
    @Test
    public void bindAccount(){
        BindAccount bindAccount = new BindAccount();
        bindAccount.GetBind(13091057, "o1Fn5sgb8unq5JotNiTXumJDdESw", "windows").then().body("code", Matchers.equalTo("40000007"));
    }
}
