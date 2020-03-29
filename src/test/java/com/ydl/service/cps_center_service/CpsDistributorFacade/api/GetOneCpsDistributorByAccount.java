package com.ydl.service.cps_center_service.CpsDistributorFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/28 15:19
 * @Description:
 */
public class GetOneCpsDistributorByAccount {
    public Response get(String account){
        return given()
                .queryParam("account", account)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsDistributorFacade/getOneCpsDistributorByAccount")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
