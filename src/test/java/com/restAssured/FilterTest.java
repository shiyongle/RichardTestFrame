package com.restAssured;

import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/1/30 15:13
 * @Description:
 */
public class FilterTest {

    /**
     * 修改请求参数、头、path等等
     * 可做加密处理,使用方法 req.getBody()
     */
    @Test
    public void filterRequest(){
        given().filter((req, res, ctx)->{
            //修改请求token
            req.queryParam("token", "xxxx");
            //修改请求path
            req.path("/CGIDEMO/cgi-bin/user_error.json");
            req.baseUri("http://127.0.0.1:8000");
            System.out.println(req.getURI());
            Response resReal = ctx.next(req, res);
            System.out.println(resReal.getStatusLine());
            return resReal;
        })
                .when().log().all().get("http://127.0.0.1:8000/CGIDEMO/cgi-bin/user.json")
                .then().log().all().statusCode(200);
    }

    /**
     * 修改响应数据
     * 例如解密等
     */
    @Test
    public void filterResponse(){
        given().filter((req, res, ctx)->{
            Response resOrigin = ctx.next(req, res);
            String bodtNew = resOrigin.getBody().asString().replace("\"userid\": \"123456789\",", "\"userid\": null,");
            ResponseBuilder responseBuilder =  new ResponseBuilder().clone(resOrigin);
            responseBuilder.setBody(bodtNew);
            return responseBuilder.build();
        })
                .when().log().all().get("http://127.0.0.1:8000/CGIDEMO/cgi-bin/user.json")
                .then().log().all().statusCode(200);
    }

    /**
     * 调用FilterDemo,修改响状态码
     * FilterDemo中已将状态码修改为400，因此此处断言为200，会失败
     */
    public void demoFilter(){
        given().filter(new FilterDemo())
                .when().log().all().get("http://127.0.0.1:8000/CGIDEMO/cgi-bin/user.json")
                .then().statusCode(200);
    }

    /**
     * 调用Base64Filter进行解密响应报文并断言
     */
    @Test
    public void base64Filter(){
        given().filter(new Base64Filter())
                .log().all().get("http://127.0.0.1:8000/CGIDEMO/cgi-bin/user.json")
                .then().log().all().body("name", equalTo("name for testing"));
    }
}
