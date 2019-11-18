package com.appium.page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Richered
 * @Date: 2019/11/16 23:20
 */
public class BasePage {
    public static AndroidDriver<WebElement>  driver;

    public static WebElement findElement(By by){
        //TODO：递归是更好的
        //TODO:处理异常弹窗，此处特处理低版本更新弹窗
        System.out.println(by);
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
        System.out.println(by);
        try {
            driver.findElement(by).click();
        }catch (Exception e){
            handleAlert();
            driver.findElement(by).click();
        }
    }

    public static List<WebElement> findElements(By by){
        System.out.println(by);
        return driver.findElements(by);
    }

    //TODO:统一处理方法
     static void handleAlert() {
        By tips = By.id("com.xueqiu.android:id/snb_tip_text");
        List<By> alertBoxs = new ArrayList<>();
        //TODO：不需要所有的都判断是否存在
        alertBoxs.add(By.id("com.xueqiu.android:id/image_cancel"));
        alertBoxs.add(tips);
        alertBoxs.add(By.id("com.xueqiu.android:id/md_buttonDefaultNegative"));
//        alertBoxs.add(By.xpath("ddd"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        alertBoxs.forEach(alert->{
            List<WebElement> ads=driver.findElements(alert);
            //TODO:处理第一次进入自选股页面的遮罩
            if (alert.equals(tips)){
                System.out.println("snb_tip found");
                Dimension size = driver.manage().window().getSize();
                try {
                    if (driver.findElements(tips).size() >=1) {
                        new TouchAction(driver).tap(PointOption.point(size.width / 2, size.height / 2)).perform();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("snb_tip click");
                }
                //TODO:处理首页的更新弹窗
            } else if(ads.size()>=1){
                ads.get(0).click();
            }
        });
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
