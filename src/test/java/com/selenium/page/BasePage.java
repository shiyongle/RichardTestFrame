package com.selenium.page;

/**
 * @Author Richered
 * 封装查找元素方式以及等待等
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;
    public BasePage(){
        System.setProperty("webdriver.chrome.driver", "D:\\IDEAWorkSpace\\TestUIFrame\\testPo\\src\\test\\java\\com\\selenium\\utils\\chromedriver.exe");
    }
    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    public WebElement findElement(By by, int timeout){
        System.out.println(by);
        if(timeout>0) {
            waitClickable(by, timeout);
            System.out.println("clickable");
        }
        return driver.findElement(by);
    }

    public void waitClickable(By by, int timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitClickable(By by){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(by));

    }

    public void quit() throws InterruptedException {
        Thread.sleep(20000);
        driver.quit();
    }
}
