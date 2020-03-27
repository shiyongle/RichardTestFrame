package com.ydl.service.test_ydl_login_service.AccountFacede.api;

import com.service.Work;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 11:07
 * Description: 通过手机号获取账号信息
 */
public class GetAccountInfoByPhone {

    //默认城市编码
    public String countryCode = "0086";

    public Response getInfoByPhone(String phone){
         return given()
                .queryParam("countryCode", this.countryCode)
                .queryParam("phone", phone)
                .contentType(ContentType.JSON)
         .when()
                .log().all()
                .post("http://47.97.49.44:9092/h/com.ydl.login.intf.facade.AccountFacade/getAccountInfoByPhone")
         .then()
                .log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
