package com.selenium.testcase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestDemo {
    private WebDriver driver;
    @Test
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\DevelopWorkSpace\\TestUIFrame\\testPo\\src\\test\\java\\com\\selenium\\utils\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();

        System.out.println(driver.manage().getCookies());

        driver.manage().addCookie(new Cookie("wwrtx.refid", "13622058792853559"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "nLJ7rC1inEtqLexzNPBiL8LVc6SfUSJkBTV4BnH6BIQ3v80lDX6CxAgMD0O"));
        System.out.println(driver.manage().getCookies());

        driver.navigate().refresh();
    }
}
