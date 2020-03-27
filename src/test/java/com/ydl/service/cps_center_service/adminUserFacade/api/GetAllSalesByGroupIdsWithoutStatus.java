package com.ydl.service.cps_center_service.adminUserFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:07
 * Description:
 */
public class GetAllSalesByGroupIdsWithoutStatus {
    public Response getAll(int[] groupIds){
        return given()
                .queryParam("groupIds", groupIds)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.AdminUserFacade/getAllSalesByGroupIdsWithoutStatus")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
