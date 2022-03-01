package com.weiyi.api.increment;

import com.weiyi.Utils.Common;
import com.weiyi.Utils.CreateUserToken;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2022/2/18 15:30
 * @Description
 */
public class VipQuery extends Common {

    /**
     * 判断当前登录用户是否有响应的会员商品
     * @param specNo
     * @return
     */
    public Response isVipBySku(String specNo){

        Map<String, Object> data = new HashMap<>();
        data.put("specNo",specNo);

        return given()
                    .header("Content-type", "application/json")
                    .header("weiyi-authtoken", CreateUserToken.getInstance().getToken())
                    .header("weiyi-appid", APP_ID)
                    .header("source-id", SOURCE_ID)
                    .body(data)
                .when()
                    .post(MODULE_VIP_URL + "/healthvip/rest/common/black/isvipbysku")
                .then()
                    .log().all()
                    .extract().response();
    }

    /**
     * 根据商品规格免费领取会员
     * @param purchaseName
     * @param purchaseMobile
     * @param specNo
     * @param validateCode
     * @return
     */
    public Response freeReceive(String purchaseName, String purchaseMobile, String specNo, String validateCode){

        Map<String, Object> data = new HashMap<>();
        data.put("purchaseName",purchaseName);
        data.put("purchaseMobile",purchaseMobile);
        data.put("specNo",specNo);
        data.put("validateCode",validateCode);

        return given()
                .header("Content-type", "application/json")
                .header("weiyi-authtoken", CreateUserToken.getInstance().getToken())
                .header("weiyi-appid", APP_ID)
                .header("source-id", SOURCE_ID)
                .body(data)
                .when()
                .post(MODULE_VIP_URL + "/healthvip/rest/activity/black/freereceive")
                .then()
                .log().all()
                .extract().response();
    }

    /**
     * 引流会员发送验证码
     * @param mobile
     * @return
     */
    public Response sendMobile(String mobile){
        Map<String, Object> data = new HashMap<>();
        data.put("mobile",mobile);

        return given()
                .header("Content-type", "application/json")
                .header("weiyi-authtoken", CreateUserToken.getInstance().getToken())
                .header("weiyi-appid", APP_ID)
                .header("source-id", SOURCE_ID)
                .body(data)
                .when()
                .post(MODULE_VIP_URL + "/healthvip/rest/vcode/black/yl/sendmobilevcode")
                .then()
                .log().all()
                .extract().response();
    }
}
