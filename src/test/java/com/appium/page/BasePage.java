package com.appium.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2019/11/16 23:20
 */
public class BasePage {
    public static AndroidDriver driver;

    public static WebElement findElement(By by){
        //TODO：递归是更好的
        //TODO:处理异常弹窗，此处特处理低版本更新弹窗
        try {
            return driver.findElement(by);
        }catch (Exception e){
            handleAlert();

            return driver.findElement(by);

        }
    }


    public static void click(By by){
        //TODO：递归是更好的
        //TODO:处理异常弹窗，此处特处理低版本更新弹窗
        try {
            driver.findElement(by).click();
        }catch (Exception e){
            handleAlert();
            driver.findElement(by).click();
        }
    }

    //TODO:统一处理方法
    private static void handleAlert() {
        List<By> alertBoxs = new ArrayList<>();
        //TODO：不需要所有的都判断是否存在
        alertBoxs.add(By.id("com.xueqiu.android:id/image_cancel"));
//        alertBoxs.add(By.xpath("ddd"));

        alertBoxs.forEach(alert->{
            By adsLocator = alert;
            List<WebElement> ads=driver.findElements(adsLocator);
            if(ads.size()>=1){
                ads.get(0).click();
            }
        });
    }

    //TODO:处理多弹窗
    public static void handleAlertByPageSource(){
        //todo: xpath匹配， 标记 定位
        String xml = driver.getPageSource();
        List<String> alertBox = new ArrayList<>();
        alertBox.add("xxx");
        alertBox.add("yyy");

        alertBox.forEach(alert->{
            if (xml.contains(alert)){
                driver.findElement(By.id(alert)).click();
            }
            });
    }
}
