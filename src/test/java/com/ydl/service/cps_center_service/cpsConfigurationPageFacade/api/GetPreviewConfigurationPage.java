package com.ydl.service.cps_center_service.cpsConfigurationPageFacade.api;

import com.ydl.service.Base.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @Author: Richered
 * @Date: 2020/3/27 17:26
 * Description: 需要dubbo加密处理
 */
public class GetPreviewConfigurationPage extends BaseApi {
    public Response getPreviewConfigurationPage( HashMap<String, Object> data){
        String body = template("com/ydl/service/cps_center_service/cpsConfigurationPageFacade/api/GetPreviewConfigurationPage.json",data);
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when().log().all().post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsConfigurationPageFacade/getPreviewConfigurationPage")
                .then().log().all().extract().response();
    }
}
