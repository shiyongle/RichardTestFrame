package com.ydl.service.cps_center_service.adminUserFacade.api;

import com.ydl.service.Base.BaseApi;
import io.restassured.response.Response;

import java.util.HashMap;


/**
 * @Author: Richered
 * @Date: 2020/3/27 17:09
 * Description:
 */
public class QueryHollyAccount extends BaseApi {
    public Response get(String userName) {
//        return given()
//                .queryParam("userName", userName)
//                .contentType(ContentType.JSON)
//                .when().log().all()
//                .post(baseURI + ":" + port + basePath)
//                .then()
//                .extract().response();
//    }
        HashMap<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        setParams(params);
        return parseSteps();
    }
}
