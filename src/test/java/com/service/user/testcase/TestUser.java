package com.service.user.testcase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.service.user.api.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

/**
 * @Author: Richered
 * @Date: 2020/1/10 16:59
 * @Description:
 */
public class TestUser {

    @Test
    public void info(){
        User user = new User();
        user.get("123456789").then().body("name", equalTo("Richared"));
    }

    @Test
    public void schema(){
        User user = new User();
        user.get("123456789").then().body(matchesJsonSchemaInClasspath("com/service/user/testcase/user_get_schema.json"));    }

    @Test
    public void update(){
        User user = new User();
        String userid = "123456789";
        String nameNew = "name for testing";
        HashMap<String , Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("address", "address for testing");
        user.update(userid, data);
        user.get(userid).then().body("name", equalTo(nameNew));
    }


    @Test
    public void create(){
        String nameNew = "name for testing" + System.currentTimeMillis();
        String userid = "Richered_" + System.currentTimeMillis();

        HashMap<String , Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("department", new int[]{1});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));
        data.put("address", "address for testing");

        User user = new User();
        user.create(userid, data).then().body("errcode", equalTo(0));
        user.get(userid).then().body("name", equalTo(nameNew));
    }

    /**
     * 模板技术用例
     */
    @Test
    public void cloneUser(){
        String nameNew = "name for testing" + System.currentTimeMillis();
        String userid = "Richered_" + System.currentTimeMillis();

        HashMap<String , Object> data = new HashMap<>();
        data.put("name", nameNew);
//        data.put("department", new int[]{1});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

        User user = new User();
        user.clone(userid, data).then().body("errcode", equalTo(0));
        user.get(userid).then().body("name", equalTo(nameNew));
    }

    /**
     * debug方法
     * 此处模板方法目的：根据user.json模板进行传参，只更改name、department、mobile参数
     * mustache的处理方式
     */
    @Test
    public void template() throws IOException {
        HashMap<String ,Object> data = new HashMap<String , Object>();
        data.put("name", "Mustache");
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0, 11));
        data.put("userid", System.currentTimeMillis());

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(this.getClass().getResource("/com/service/user/api/user.json").getPath());
        mustache.execute(writer, data);
        writer.flush();
    }

    /**
     * 删除成员用例
     * 先创建【使用模板用例】，再进行删除
     */
    @Test
    public void delete(){
        String nameNew = "name for testing" + System.currentTimeMillis();
        String userid = "Richered_" + System.currentTimeMillis();

        HashMap<String , Object> data = new HashMap<>();
        data.put("name", nameNew);
//        data.put("department", new int[]{1});
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

        User user = new User();
        user.clone(userid, data).then().body("errcode", equalTo(0));

        user.delete(userid).then().body("errcode", equalTo(0));

        //再次获取userid，其状态码不等于0
        user.get(userid).then().body("errcode", not(equalTo(0)));
    }

    /**
     * CsvSource注解为参数化,和testNg的dataprovider一样
     * CsvFileSource注解为读取外部数据源文件
     * MethodSource为指定方法进行解析
     * @param name
     * @param userid
     */
    @ParameterizedTest
//    @CsvSource({
//            "abc", "abc",
//            "mn","mn",
//            "1111","2222"
//    })
//    @CsvFileSource(resources = "TestUser.csv")
    @MethodSource("deleteByParamsFromYamlData")
    public void deleteByParams(String name, String userid, List<Integer> departs){
        String nameNew = name;
        if (userid.isEmpty()) {
            userid = "Richered_" + System.currentTimeMillis();
        }
        if (departs ==null){
            departs = Arrays.asList(1);
        }
        HashMap<String , Object> data = new HashMap<>();
        data.put("name", nameNew);
//        data.put("department", new int[]{1});
        data.put("department",departs);
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0,11));

        User user = new User();
        user.create(userid, data).then().body("errcode", equalTo(0));

        user.delete(userid).then().body("errcode", equalTo(0));

        //再次获取userid，其状态码不等于0
        user.get(userid).then().body("errcode", not(equalTo(0)));
    }

    /**
     * 参数化读取文件数据方法
     * @return
     */
    static Stream<Arguments> deleteByParamsFromYamlData(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        //生成一个代表List<HashMap>的类型，用于传递给readValue
        TypeReference<List<HashMap<String, Object>>> typeRef =
                new TypeReference<List<HashMap<String, Object>>>() {
                };
//        String fileName = Thread.currentThread().getStackTrace()[1].getMethodName();

        List<HashMap<String, Object>> data;
        try {
            data = mapper.readValue(
                    TestUser.class.getResourceAsStream("TestUser.yaml"),
                    typeRef);
            ArrayList<Arguments> results = new ArrayList<>();
            data.forEach(map -> {
                results.add(arguments(
                        map.get("name").toString(),
                        map.get("userid").toString(),
                        map.get("departs")
                ));
            });

            return results.stream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of();
    }

    /**
     * 获取部门成员
     * department_id为部门id
     * fetch_child:1为递归，遍历其部门id下的所有承运；-1不遍历
     */
    @Test
    public void simplelist(){
        User user = new User();
        user.simplelist(1, 1).then().body("errcode", equalTo(0));
    }

    /**
     * 批量删除
     * TODO：该api的响应报文与接口文档不符
     */
    @Test
    public void batchDelete(){
        HashMap<String , Object> data = new HashMap<>();
        data.put("useridlist", new String[]{"Richered_1578820866548","Richered_1578820553183"});
        User user = new User();
        user.betchDelete(data).then().body("errcode", equalTo(0));
    }
}
