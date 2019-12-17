package com.unit;

import com.appium.page.App;
import com.appium.page.BasePage;
import com.appium.page.PageObjectMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;
import org.nfunk.jep.JEP;

import java.math.BigDecimal;
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


    /**
     * 因子分值计算
     */
    @Test
    public void CALC() {
        String ex = "if(AGENCY==2,if(CS>=3,if(CS>=5,if(CS>=10,if(CS>=15,-10000,-8000),-6000),-4000),0),if(CS>=5,if(CS>=8,if(CS>=12,if(CS>=16,-10000,-8000),-6000),-4000),0))";
        JEP jep = new JEP();
        jep.addComplex();
        jep.addStandardFunctions();
        jep.addStandardConstants();

        jep.addVariable("DCS1H", 4);
        jep.addVariable("DWHF1H", 0.5);
        jep.addVariable("WHF1H", 1);
        jep.addVariable("CS1H", 1);
        jep.addVariable("AGENCY", 1);
        jep.parseExpression(ex);
        System.out.println(jep.hasError());
        System.out.println(jep.getErrorInfo());
        System.out.println(jep.getValue());

        BigDecimal bd = new BigDecimal("1.575869649E9");
        System.out.println(bd.toPlainString());
    }
}
