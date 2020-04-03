package com.ydl.service.cps_center_service.cpsConfigurationPageFacade.api;

import com.ydl.service.Base.BaseApi;
import io.restassured.response.Response;

import java.util.HashMap;


/**
 * @Author: Richered
 * @Date: 2020/3/27 17:18
 * Description:
 */
public class GetConfigurationPage extends BaseApi {
    public Response get(int distributorId, int channelId, int productType){
//        return given()
//                .queryParam("distributorId", distributorId)
//                .queryParam("channelId", channelId)
//                .queryParam("productType", productType)
//                .contentType(ContentType.JSON)
//                .when().log().all()
//                .post("http://47.96.181.183:10088/h/com.ydl.wo.intf.facade.CpsConfigurationPageFacade/getConfigurationPage")
//                .then().log().all()
//                .body("code", equalTo("200"))
//                .extract().response();
        HashMap<String, Object> params = new HashMap<>();
        params.put("distributorId", distributorId);
        params.put("channelId", channelId);
        params.put("productType", productType);
        setParams(params);
        return parseSteps();
    }
}
