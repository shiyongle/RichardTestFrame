package com.selenium.page;
/**
 * @Author Richered
 * 封装页面对象以及登录
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App extends BasePage {
    public App loginWithCookie(){
        String url="https://work.weixin.qq.com/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();

        System.out.println(driver.manage().getCookies());
        //如发现刷新不能登录，则需要确认cookie是否正确
        driver.manage().addCookie(new Cookie("wwrtx.refid", "1650172028286419"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "nLJ7rC1inEtqLexzNPBiL8rrP8cz5gSut4RODnqb0mrlgchpivoG2OvvoEnksjVz"));
        driver.navigate().refresh();
        return this;
    }
    public ContactPage toContact(){
        findElement(By.linkText("通讯录")).click();
        return new ContactPage();
    }
    public ContactPage toMemberAdd(){
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }

    public BroadcastPage toGroupMessage(){
        findElement(By.linkText("管理工具")).click();
        findElement(By.cssSelector(".ww_icon_AppGroupMessageBig")).click();
        return new BroadcastPage();
    }

}
