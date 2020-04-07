package com.ydl.service.cps_center_service.cpsConfigurationPageFacade.api;

import com.ydl.service.Base.BaseApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


/**
 * @Author: Richered
 * @Date: 2020/3/27 17:26
 * Description: 需要dubbo加密处理
 */
public class GetPreviewConfigurationPage extends BaseApi {

    /**
     * Mustache模板封装
     * @param data
     * @return
     */
    public Response getPreviewConfigurationPage(HashMap<String, Object> data){
        RestAssured.baseURI = "http://47.96.181.183";
        RestAssured.basePath = "/h/com.ydl.wo.intf.facade.CpsConfigurationPageFacade/getPreviewConfigurationPage";
        RestAssured.port = 10088;
        GetPreviewConfigurationPage demo = new GetPreviewConfigurationPage();
        String body = template("com/ydl/service/cps_center_service/cpsConfigurationPageFacade/api/GetPreviewConfigurationPage.json",data);
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when().log().all().post(RestAssured.baseURI+":"+RestAssured.port + RestAssured.basePath)
                .then().log().all().extract().response();
    }
}
