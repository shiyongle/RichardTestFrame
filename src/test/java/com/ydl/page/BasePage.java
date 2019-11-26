package com.ydl.page;


import com.appium.page.TestCaseSteps;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BasePage {
    public static AndroidDriver<WebElement> driver;

    private static HashMap<String,Object> params;

    public HashMap<String, Object> getParams() {
        return params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }

    public static WebElement findEelement(By by){
        System.out.println(by);
        try {
            return driver.findElement(by);
        }catch (Exception e){
            handAlert();
            return driver.findElement(by);
        }
    }

    public static void click(By by){
        //TODO：递归是更好的
        //TODO:处理异常弹窗，此处特处理低版本更新弹窗
        System.out.println(by);
        try {
            driver.findElement(by).click();
        }catch (Exception e){
            handAlert();
            driver.findElement(by).click();
        }
    }

    //TODO：处理首页更新弹窗
    public static void handAlert(){
        try {
            driver.findElement(By.id("com.cxzapp.yidianling:id/tv_cancel")).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void parseSteps(String method) {
//        HashMap<String, List<HashMap<String, String>>> 可以取消steps的多余关键字
        //TODO: 参数化，把关键数据参数化到你的yaml中
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String path = "/" + this.getClass().getCanonicalName().replace('.', '/') + ".yaml";
        TypeReference<HashMap<String, com.appium.page.TestCaseSteps>> typeRef = new TypeReference<HashMap<String, com.appium.page.TestCaseSteps>>() {
        };
        try {
            HashMap<String, com.appium.page.TestCaseSteps> steps = mapper.readValue(
                    this.getClass().getResourceAsStream(path), typeRef
            );
            parseSteps(steps.get(method));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void parseSteps(String path, String method){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<HashMap<String, com.appium.page.TestCaseSteps>> typeRef = new TypeReference<HashMap<String, com.appium.page.TestCaseSteps>>() {
        };
        try {
            HashMap<String, com.appium.page.TestCaseSteps> steps = mapper.readValue(
                    com.appium.page.BasePage.class.getResourceAsStream(path), typeRef
            );
            parseSteps(steps.get(method));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void parseSteps(TestCaseSteps steps){
        steps.getSteps().forEach(step->{
            WebElement element = null;

            //todo: 多个可能定位，多平台支持，多版本的支持
            String id=step.get("id");
            if(id!=null){
                element=driver.findElement(By.id(id));
            }

            String xpath=step.get("xpath");
            if(xpath!=null){
                element=driver.findElement(By.xpath(xpath));
            }

            String aid=step.get("aid");
            if(aid!=null){
                element=driver.findElement(MobileBy.AccessibilityId(aid));
            }

            String send=step.get("send");
//            send.replaceAll("{.*}", "dd")
            if(send!=null){
                //配置文件中的参数替换
                for(Map.Entry<String, Object> kv: params.entrySet()){
                    String matcher="${"+kv.getKey()+"}";
                    if(send.contains(matcher)) {
                        System.out.println(kv);
                        send = send.replace(matcher, kv.getValue().toString());
                    }
                }
                element.sendKeys(send);
            }else if(step.get("get")!=null){
                element.getAttribute(step.get("get"));
            }else{
                element.click();
            }

        });
    }
}
