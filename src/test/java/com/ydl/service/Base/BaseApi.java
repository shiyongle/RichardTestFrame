package com.ydl.service.Base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import io.restassured.response.Response;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

/**
 * @Author: Richered
 * @Date: 2020/4/3 10:59
 * Description:
 */
public class BaseApi {
    ApiObjectModel model = new ApiObjectModel();
    HashMap<String, Object> params;

    public Response parseSteps(){
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(method);

        if(model.methods.entrySet().isEmpty()) {
            System.out.println("pom first load");
            String path = "/" + this.getClass().getCanonicalName().replace('.', '/') + ".yaml";
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                model = mapper.readValue(
                        com.ydl.service.Base.BaseApi.class.getResourceAsStream(path), ApiObjectModel.class
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (Response) model.run(method, params);
    }

    /**
     * 替换yaml文件中的参数;params的实体类set方法
     */
    public void setParams(HashMap<String, Object> data){
        params = data;
    }

    /**
     * 封装mustache模板技术
     * @param templatePath
     * @param data
     * @return
     */
    public String template(String templatePath, HashMap<String, Object> data){
        Writer writer = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(templatePath);
        mustache.execute(writer, data);
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
