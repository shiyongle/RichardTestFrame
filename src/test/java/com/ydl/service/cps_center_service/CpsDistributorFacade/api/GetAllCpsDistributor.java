package com.ydl.service.cps_center_service.CpsDistributorFacade.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/3/28 15:07
 * @Description:
 */
public class GetAllCpsDistributor {

    //开启
    private int cpsStatus_true = 1;
    //关闭
    private int cpsStatus_false = 0;


    public Response get(String distributorId, int page, int limit){
        return given()
                .queryParam("distributorId", distributorId)
                .queryParam("cpsStatus", this.cpsStatus_true)
                .queryParam("page", page)
                .queryParam("limit", limit)
                .contentType(ContentType.JSON)
                .when().log().all()
                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsDistributorFacade/getAllCpsDistributor")
                .then().log().all()
                .body("code", equalTo("200"))
                .extract().response();
    }
}
