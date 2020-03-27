package com.ydl.service.test_ydl_login_service.AccountFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:07
 * Description: 绑定账号
 *
 */
public class BindAccount {
    public Response GetBind(long uid, String openid, String platform){
        return given()
                .queryParam("uid", uid)
                .queryParam("openId", openid)
                .queryParam("platform", platform)
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AccountFacade/bindAccount")
                .then()
                .log().all()
                .body("code", equalTo("40000007"))
                .extract().response();
    }
}
