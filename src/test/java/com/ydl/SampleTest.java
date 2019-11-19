package com.ydl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("platformVersion", "6.0.1");
        desiredCapabilities.setCapability("appPackage","com.cxzapp.yidianling");
        desiredCapabilities.setCapability("appActivity",".splash.SplashActivity");
        desiredCapabilities.setCapability("noReset",true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() {
//        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("心理咨询壹点灵");
//        el1.click();
        try {
            driver.findElement(By.id("com.cxzapp.yidianling:id/tv_cancel")).click();
        }catch (Exception e){
            e.printStackTrace();
        }

//        MobileElement el1 = (MobileElement) driver.findElementById("com.cxzapp.yidianling:id/tv_cancel");
//        el1.click();
        //TODO：点击我的
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[5]/android.widget.LinearLayout/android.widget.ImageView");
        el2.click();
        el2.click();
        //TODO：点击登录
        MobileElement el3 = (MobileElement) driver.findElementById("com.cxzapp.yidianling:id/tv_duration");
        el3.click();
        //TODO：输入账号
        MobileElement el4 = (MobileElement) driver.findElementById("com.cxzapp.yidianling:id/et_phone_number");
        el4.sendKeys("13216101995");
        //TODO：点击继续
        MobileElement el5 = (MobileElement) driver.findElementById("com.cxzapp.yidianling:id/iv_next");
        el5.click();
        //TODO：点击输入密码
        MobileElement el6 = (MobileElement) driver.findElementById("com.cxzapp.yidianling:id/et_input_password");
        el6.sendKeys("s19951226");
        //TODO：点击继续
        MobileElement el7 = (MobileElement) driver.findElementById("com.cxzapp.yidianling:id/input_iv_next");
        el7.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

