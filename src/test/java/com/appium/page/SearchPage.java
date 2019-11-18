package com.appium.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @Author: Richered
 * @Date: 2019/11/16 23:24
 * @Description：搜索paga
 */
public class SearchPage extends BasePage {
    private By inputBox= By.id("com.xueqiu.android:id/search_input_text");
//    private By name=By.id("com.xueqiu.android:id/name");

    public SearchPage search(String keyword){
//        HashMap<String ,Object> data = new HashMap<>();
//        data.put("keyword",keyword);
        //TODO：Test类传值
        App.driver.findElement(inputBox).sendKeys(keyword);
        //TODO：点击搜索框下方的搜索结果
        click(By.id("com.xueqiu.android:id/name"));
        //TODO：点击“股票”模块【新版本需要模块的切换，老版本不需要】
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView"));
        return this;
    }

    public Float getCurrentPrice(){
        MobileElement el4 = (MobileElement)findElement(By.id("com.xueqiu.android:id/current_price"));
//        el4.click();
        return Float.valueOf(el4.getText());
    }

    /**
     * 取消操作
     * @return app首页
     */
    public App cancel(){
        click(By.id("com.xueqiu.android:id/action_close"));
        return new App();
    }

    /**
     * 查询操作
     * @return
     */
    public SearchPage select(){
        click(By.id("com.xueqiu.android:id/follow_btn"));
        return this;
    }
}
