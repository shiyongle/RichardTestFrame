package com.ydl.service.test_ydl_login_service.AccountFacede.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:36
 * Description: 手机号更新
 */
public class UpDatePhone {

    //默认城市编码
    public String countryCode = "0086";

    public Response modify(long uid, String newphone){
        return given()
                .queryParam("countryCode", this.countryCode)
                .queryParam("uid", uid)
                .queryParam("newPhone", newphone)
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AccountFacade/updatePhone")
                .then()
                .log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
