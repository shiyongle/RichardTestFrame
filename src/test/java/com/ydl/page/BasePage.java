package com.ydl.page;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static AndroidDriver<WebElement> driver;

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
}
