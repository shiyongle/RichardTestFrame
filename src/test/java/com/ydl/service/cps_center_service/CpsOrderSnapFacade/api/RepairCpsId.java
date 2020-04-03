package com.ydl.service.cps_center_service.CpsOrderSnapFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/30 14:18
 * Description:
 */
public class RepairCpsId {
    public Response get(){
        return given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsOrderSnapFacade/repairCpsId")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
