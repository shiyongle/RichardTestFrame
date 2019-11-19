package com.ydl.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    public static void start() throws MalformedURLException {
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

    public static MePage toMePage(){
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[5]/android.widget.LinearLayout/android.widget.ImageView"));
        return new MePage();
    }
}
