package com.service.department.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
 * @Description: 标签部分interface
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

    /**
     * 获取标签成员列表
     * @return
     */
    public Response listTagUser(){
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("tagid", 1)
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/get")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
        .extract().response();
    }

    /**
     * 添加标签成员
     * @return
     */
    public Response addTagUser(){
        JSONObject jsonObject = new JSONObject();
        JSONArray bean1 = new JSONArray();
        JSONArray bean2 = new JSONArray();

        /**
         * bean为数组
         */
        String user1 = "user1";
        String user2 = "user2";
        bean1.add(user1);
        bean1.add(user2);

        /**parylist是企业部门id**/
        int parylist = 3;
        bean2.add(parylist);


        jsonObject.put("userlist",bean1);
        jsonObject.put("partylist",bean2);
        jsonObject.put("tagid",1);
        System.out.println(jsonObject);

        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(jsonObject)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
        .extract().response();
    }

    /**
     * 删除标签陈媛
     * @return
     */
    public Response deleteTagUser(){
        JSONObject jsonObject = new JSONObject();
        JSONArray bean1 = new JSONArray();
        JSONArray bean2 = new JSONArray();
        /**
         * bean为数组
         */
        String user1 = "user1";
        String user2 = "user2";
        bean1.add(user1);
        bean1.add(user2);

        /**parylist是企业部门id**/
        int parylist = 3;
        bean2.add(parylist);

        jsonObject.put("tagid",1);
        jsonObject.put("userlist",bean1);
        jsonObject.put("partylist",bean2);
        System.out.println(jsonObject);

        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(jsonObject)
        .when()
                .log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers")
        .then()
                .log().all()
                .body("errcode", equalTo(0))
        .extract().response();
    }
}
