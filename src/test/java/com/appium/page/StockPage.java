package com.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2019/11/17 21:45
 * @Description:自选股Page
 */
public class StockPage extends BasePage{
    //TODO:如自选股页面有股票则需要清空，调用该方法
    public StockPage deleteAll(){
//        click(By.id("com.xueqiu.android:id/edit_group"));
//        click(By.id("com.xueqiu.android:id/check_all"));
//        click(By.id("com.xueqiu.android:id/cancel_follow"));
//        click(By.id("com.xueqiu.android:id/md_buttonDefaultPositive"));
//        click(By.id("com.xueqiu.android:id/action_close"));
        parseSteps();
        return this;
    }

    public List<String> getAllStocks(){
        handleAlert();
        List<String> stocks = new ArrayList<>();
        driver.findElements(By.id("com.xueqiu.android:id/portfolio_stockName")).forEach(element->{
            stocks.add(element.getText());
        });
        System.out.println(stocks);
        return stocks;
    }

    public StockPage addDefaultSelectedStocks(){
        click(By.id("com.xueqiu.android:id/add_to_portfolio_stock"));
        return this;
    }

    public SearchPage toSearch(){
        click(By.id("com.xueqiu.android:id/action_search"));
        return new SearchPage();
    }
}
