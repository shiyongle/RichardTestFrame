package com.appium.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Richered
 * @Date: 2019/11/16 23:10
 */
public class App extends BasePage {
//    private static App app;
//    public static App getInstance(){
//        if (app == null){
//            app = new App();
//        }
//        return app;
//    }

    public static void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("platformVersion", "6.0.1");
        desiredCapabilities.setCapability("appPackage","com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset",false);
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //TODO:显式等待
        long start=System.currentTimeMillis();
        new WebDriverWait(driver, 40)
                .until(x -> {
                    String xml=driver.getPageSource();
                    Boolean exist=xml.contains("home_search") || xml.contains("image_cancel") ;
                    System.out.println((System.currentTimeMillis() - start)/1000);
                    System.out.println(exist);
                    return exist;
                });


//        //速度会比较慢
//        By adsLocator=By.id("xxx");
//        List<WebElement> ads=driver.findElements(adsLocator);
//        if(ads.size()>=1){
//            ads.get(0).click();
//        }
    }

    public static SearchPage toSearch(){
        //TODO:进入首页
//        click(By.id("com.xueqiu.android:id/tv_search"));
        parseSteps("/com/appium/page/app.yaml", "toSearch");
        return new SearchPage();
    }
    public static StockPage toStocks(){
//        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='自选']"));
        parseSteps("/com/appium/page/app.yaml", "toStocks");
        return new StockPage();
    }
}
