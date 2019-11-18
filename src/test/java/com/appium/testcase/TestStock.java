package com.appium.testcase;

import com.appium.page.App;
import com.appium.page.StockPage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;

/**
 * @Author: Richered
 * @Date: 2019/11/17 21:39
 * @Description:测试自选股用例：此处使用junit5的order注解，来控制case执行顺序
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @Order(1)
    @Test
    public void addDefaultSelectedStocks(){
        if (stockPage.getAllStocks().size() >= 1){
            stockPage.deleteAll();
        }
        assertThat(stockPage.addDefaultSelectedStocks().getAllStocks().size(), greaterThanOrEqualTo(6));
    }

    @Order(2)
    @Test
    public void addStock(){
        stockPage.toSearch().search("pdd").select().cancel();
        assertThat(stockPage.getAllStocks(), hasItem("拼多多"));
    }
}
