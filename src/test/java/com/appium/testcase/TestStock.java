package com.appium.testcase;

import com.appium.page.App;
import com.appium.page.StockPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

/**
 * @Author: Richered
 * @Date: 2019/11/17 21:39
 * @Description:测试自选股用例
 */
public class TestStock {
    private  static StockPage stockPage;
    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.start();
        stockPage = App.toStocks();
    }

    @BeforeEach
    public void beforeEach(){

    }

    @Test
    public void addDefaultSelectedStocks(){
        if (stockPage.getAllStocks().size() >= 1){
            stockPage.deleteAll();
        }

        assertThat(stockPage.addDefaultSelectedStocks().getAllStocks().size(), greaterThanOrEqualTo(6));
    }
}
