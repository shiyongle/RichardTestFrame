package com.appium.testcase;

import com.appium.page.App;
import com.appium.page.StockPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
    @ParameterizedTest
//    @ValueSource(strings = {"pdd","xiaomi"})
    @MethodSource("data")
    public void addStock(String code, String name){
        stockPage.toSearch().search(code).select().cancel();
        assertThat(stockPage.getAllStocks(), hasItem(name));
    }

    public static Stream<Arguments> data(){
        return Stream.of(
                arguments("pdd","拼多多"),
                arguments("jd","京东")
        );
    }
}
