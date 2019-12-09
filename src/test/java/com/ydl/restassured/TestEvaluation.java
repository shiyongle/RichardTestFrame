package com.ydl.restassured;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;

/**
 * @Author: Richered
 * @Date: 2019/11/28 13:51
 * Description: 测评下单
 */
public class TestEvaluation {

//    private static final Logger logger = LoggerFactory.getLogger(TestEvaluation.class);

    @Test
    public void login(){
        given()
                .queryParam("userName","16898987887")
                .header("cps_channel_p","B.100.101.107.112")
                .header("uid","13094436")
                .header("accessToken","888dbc97f1488af87988b11cd9fd90c1MTkxMTI4")
        .when()
                .post("http://testnewm.ydl.com/user/login")
        .then()
                .statusCode(200);
    }


    @Test
    public void TestGetHtml(){
        given()
                .log().all().get("https://www.baidu.com")
                .then().log().all().statusCode(200);
    }
}
