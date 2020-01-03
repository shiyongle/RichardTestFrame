package com.service.Tag.api;

import com.service.Work;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @Author: Richered
 * @Date: 2020/1/3 22:08
 * @Description:
 */
public class Tag {
    
    /**
     * 创建标签
     * @param tagname
     * @param tagid
     */
    public Response addTag(String tagname, int tagid){
        Map<String, Object> data = new HashMap<>();
        data.put("tagname",tagname);
        data.put("tagid",tagid);
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
        .extract().response();
    }

    /**
     * 修改标签
     * @param tagid
     * @param tagname
     * @return
     */
    public Response updateTag(int tagid, String tagname){
        Map<String, Object> data = new HashMap<>();
        data.put("tagid",tagid);
        data.put("tagname",tagname);
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/update")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
        .extract().response();
    }

    /**
     * 删除标签
     * @param tagid
     * @return
     */
    public Response deleteTag(int tagid){
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("tagid", tagid)
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/delete")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
        .extract().response();
    }

    /**
     * 获取标签列表
     * @return
     */
    public Response listTag(){
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/list")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
        .extract().response();
    }
}
