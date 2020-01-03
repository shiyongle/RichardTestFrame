package com.service;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

/**
 * @Author: Richered
 * @Date: 2020/1/3 11:24
 * Description:获取雪球自选部分的json
 */
public class TestXueQiu {
    @Test
    public void stock(){
        given()
                .queryParam("Host","stock.xueqiu.com")
                .cookie("xq_a_token","db2f6e470bdc039bed9f16a0ccc8af921c56b6bc")
                .cookie("u","4880876160")
                .cookie("xid","0")
        .when()
                .log().all()
                .get("https://stock.xueqiu.com/v5/stock/portfolio/stock/list.json?_t=1NETEASEf0320ca31fb6036d944720a1f8ef4ace.4880876160.1578017373119.1578021818608&_s=1cb0f6&size=10000&page=1&category=1&pid=-1 ")
        .then()
                .log().all()
                .statusCode(200);
    }
}
