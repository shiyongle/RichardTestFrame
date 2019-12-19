package com.restAssured;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

/**
 * @Author: Richered
 * @Date: 2019/12/17 16:54
 * Description:allure maven jenkins demo
 */

@Epic("Allure Epic")
@Feature("Allure Feature")
public class AllureDemo {
//    @Test
//    public void calc1(){
//        System.out.println("calc1");
//    }
//
//    @Test
//    public void calc2(){
//        System.out.println("calc2");
//    }

//    @BeforeTest
    public void testallure(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "CGIProject/cgi-bin/";
        RestAssured.port = 8000;
    }


    @Story("无")
    @Description("本地cgi接口")
    @Issue("local")
    @TmsLink("local-cgi")
//    @Title("local-cgi")
    @Severity(SeverityLevel.BLOCKER)
//    @Test
    public void runtest() throws IOException, URISyntaxException {
        String name = "richard";
        String bodyString =  "{\n" + "\t\"username\":\"" + name + "}\n";
        System.out.println(bodyString);
        requestBody(RestAssured.baseURI+":"+RestAssured.port+"/"+RestAssured.basePath,bodyString);
        Response response = given()
                .log().all()
                .contentType("application/json;charset=UTF-8")
                .request()
                .body(bodyString)
                .post();
        response.prettyPrint();//格式化参数

        //断言
        String json = response.asString();
        JsonPath jp = new JsonPath(json);

        //测试报告展现 请求报文
        respondBody(json);
    }

    @Step
    public void requestBody(String URL,String Body){
        //报告展现请求报文
    }

    @Step
    public void respondBody(String Respond){
        //报告展现响应报文
    }

}
