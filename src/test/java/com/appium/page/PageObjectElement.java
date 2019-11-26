package com.appium.page;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2019/11/26 22:20
 * @Description:
 */
public class PageObjectElement {
    public List<HashMap<String, String>> element;
    public By getLocator(){
        //todo: xxxx

        String osOrigin=BasePage.driver.getCapabilities().getPlatform().toString().toLowerCase();
        return By.id("xxx");
    }
    public By getLocator(String os, String version){


        for(HashMap<String, String> map : element){
            if(map.get("os")==os && map.get("version")==version){
                if(map.get("id")!=null){
                    return By.id(map.get("id"));
                }else if(map.get("xpath")!=null){
                    return By.xpath((map.get("xpath")));
                }
                break;
            }
        }
        return null;
    }
}
