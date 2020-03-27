package com.ydl.service.test_ydl_login_service.AccountFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:32
 * Description: 解除账号绑定
 */
public class UnBindAccount {
    public Response GetUnBind(long uid, String openid, String platform){
        return given()
                .queryParam("uid", uid)
                .queryParam("openId", openid)
                .queryParam("platform", platform)
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AccountFacade/unBindAccount")
                .then()
                .log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
