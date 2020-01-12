package com.service.user.api;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.service.Work;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

/**
 * @Author: Richered
 * @Date: 2020/1/10 16:58
 * @Description: 成员部分
 */
public class User {

    /**
     * 读取成员
     * @param userid
     * @return
     */
    public Response get(String userid){
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("userid", userid)
                .when().log().all()
                        .get("https://qyapi.weixin.qq.com/cgi-bin/user/get")
                .then().log().all()
                        .extract().response();
    }

    /**
     * 更新成员
     * @param userid
     * @param data
     * @return
     */
    public Response update(String userid, HashMap<String, Object> data) {
        data.put("userid", userid);
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .body(data)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/update")
                .then().extract().response();
    }


    /**
     * 创建成员
     * @param userid
     * @param data
     * @return
     */
    public Response create(String userid, HashMap<String, Object> data) {
        data.put("userid", userid);
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .body(data)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().extract().response();
    }

    /**
     * 模板技术
     * @param userid
     * @param data
     * @return
     */
    public Response clone(String userid, HashMap<String, Object> data) {
        data.put("userid", userid);
        String body = template("/com/service/user/api/user.json",data);
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().extract().response();
    }


    /**
     * 封装json模板:读取resources目录下的json文件
     * @param templatePath 模板路径
     * @param data 需要更改的数据
     * @return
     */
    public String template(String templatePath, HashMap<String ,Object> data){
        Writer writer = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(this.getClass().getResource(templatePath).getPath());
        mustache.execute(writer, data);
        try{
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        return writer.toString();
    }

    /**
     * 删除成员
     * @param userid
     * @return
     */
    public Response delete(String userid) {
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("userid", userid)
                .when().log().all()
                       .post("https://qyapi.weixin.qq.com/cgi-bin/user/delete")
                .then().log().all()
                        .extract().response();
    }

    /**
     * 批量删除成员
     * @return
     */
    public Response betchDelete(HashMap<String ,Object> data){
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .body(data)
                .when().log().all()
                        .post("https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete")
                .then().log().all()
                       .extract().response();
    }

    /**
     * 获取部门成员
     * @return
     */
    public Response simplelist(int department_id){
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("department_id",department_id)
                .queryParam("fetch_child",1)
                .when().log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/user/simplelist")
                .then().log().all()
                .extract().response();
    }
}
