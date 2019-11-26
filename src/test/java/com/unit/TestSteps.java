package com.unit;

import com.appium.page.App;
import com.appium.page.BasePage;
import com.appium.page.PageObjectMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2019/11/20 23:54
 * @Description:
 */
public class TestSteps {

    @Test
    public void steps() throws JsonProcessingException {
        HashMap<String, PageObjectMethod> testcase = new HashMap<String, PageObjectMethod>();
        PageObjectMethod testcaseStep =new PageObjectMethod();
        List<HashMap<String, String>> steps=new ArrayList<>();

        HashMap<String, String> map=new HashMap<>();
        map.put("id", "xxxx");
        map.put("send", "xxxx");
        steps.add(map);
        steps.add(map);

        testcaseStep.setSteps(steps);
        testcase.put("search", testcaseStep);


        ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testcase));
    }
    @Test
    public void parseSteps() throws MalformedURLException {
        App.getInstance().start();
        BasePage basePage=new BasePage();
//        basePage.parseSteps("search");
        basePage.parseSteps("/com/appium/page/app.yaml","toSearch");
    }
    @Test
    public void demo(){
        Arrays.stream(Thread.currentThread().getStackTrace()).forEach(stack->{
            System.out.println(stack.getClassName()+ ":" + stack.getMethodName());
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
