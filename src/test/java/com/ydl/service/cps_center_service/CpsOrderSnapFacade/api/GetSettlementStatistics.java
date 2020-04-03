package com.ydl.service.cps_center_service.CpsOrderSnapFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 14:14
 * Description:
 */
public class GetSettlementStatistics {

    //orderIds=[94200313001058,94200311001022]

    public Response get(){
        return given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsOrderSnapFacade/getSettlementStatistics")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
