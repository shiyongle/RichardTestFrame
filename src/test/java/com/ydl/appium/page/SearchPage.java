package com.ydl.appium.page;


import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

/**
 * @Author: Richered
 * @Date: 2019/12/5 15:36
 * Description:搜索页page
 */
public class SearchPage extends BasePage{

    private By inputBox= By.id("com.xueqiu.android:id/search_input_text");

    public SearchPage search(String keyword){
        App.driver.findElement(inputBox).sendKeys(keyword);
        //TODO:控件回车
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        return this;
    }
}
