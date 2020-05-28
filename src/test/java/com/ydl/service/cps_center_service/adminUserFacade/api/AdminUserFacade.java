package com.ydl.service.cps_center_service.adminUserFacade.api;

import com.ydl.service.Base.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/4/8 11:33
 * Description:
 */
public class AdminUserFacade extends BaseApi {

    public Response getAllSalesByGroupIds(int[] groupIds){
        return given()
                .queryParam("groupIds", groupIds)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.AdminUserFacade/getAllSalesByGroupIds")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }

    public Response getAllSalesByGroupIdsWithoutStatus(int[] groupIds){
        return given()
                .queryParam("groupIds", groupIds)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.AdminUserFacade/getAllSalesByGroupIdsWithoutStatus")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }

    public Response queryHollyAccount(String userName) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        setParams(params);
        return parseSteps();
    }
}
