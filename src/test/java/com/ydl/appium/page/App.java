package com.ydl.appium.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    public static void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:7555");
        desiredCapabilities.setCapability("platformVersion", "6.0.1");
        //HuaWei Mate9
//        desiredCapabilities.setCapability("deviceName","huawei");
//        desiredCapabilities.setCapability("platformVersion", "9.0.1");
        desiredCapabilities.setCapability("appPackage","com.cxzapp.yidianling");
        desiredCapabilities.setCapability("appActivity",".splash.SplashActivity");
        desiredCapabilities.setCapability("noReset",true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //TODO:显式等待
//        long start=System.currentTimeMillis();
//        new WebDriverWait(driver, 60)
//                .until(x -> {
//                    String xml=driver.getPageSource();
//                    Boolean exist=xml.contains("home_search") || xml.contains("image_cancel") ;
//                    System.out.println((System.currentTimeMillis() - start)/1000);
//                    System.out.println(exist);
//                    return exist;
//                });
    }

    //TODO:我的模块
    public static MePage toMePage(){
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[5]/android.widget.LinearLayout/android.widget.ImageView"));
//        parseSteps("/com/ydl/page/app.yaml","toMePage");
        return new MePage();
    }

    //TODO：咨询模块
    public static ConsultationPage toConsultationPage(){
        click(By.id("com.cxzapp.yidianling:id/homeModuleButtonBannerFirstTitle"));
        return new ConsultationPage();
    }

    //TODO:倾诉模块
    public static ListenPage toListenPage(){
        click(By.id("com.cxzapp.yidianling:id/homeModuleButtonBannerSecondTitle"));
        return new ListenPage();
    }

    //TODO:课程模块
    public static CoursePage toCoursePage(){
        click(By.id("com.cxzapp.yidianling:id/homeModuleButtonBannerThirdTitle"));
        return new CoursePage();
    }

    //TODO:测评模块
    public static EvaluationPage toEvaluationPage(){
        click(By.id("com.cxzapp.yidianling:id/homeModuleButtonBannerFourthTitle"));
        return new EvaluationPage();
    }

    //TODO:问答模块
    public static QuestionPage toQuestionPage(){
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.ImageView"));
        return new QuestionPage();
    }

    //TODO:消息模块
    public static InformationPage toInformationPage(){
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[4]/android.widget.LinearLayout/android.widget.ImageView"));
        return new InformationPage();
    }

    public static SearchPage toSearchPage(){
        click(By.id("com.cxzapp.yidianling:id/home_tv"));
        return new SearchPage();
    }
}
