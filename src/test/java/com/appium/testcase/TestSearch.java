package com.appium.testcase;

import com.appium.page.App;
import com.appium.page.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * @Author: Richered
 * @Date: 2019/11/16 23:28
 */
@RunWith(Parameterized.class)
public class TestSearch {
    public static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException{
        App.start();
    }

    @Parameterized.Parameters
    public static Collection<Object> data(){
//        List<String> stocks = new ArrayList<>();
//        stocks.add("xiaomi");
//        stocks.add("alibaba");
//        stocks.add("jd");
//        return stocks;
        return Arrays.asList(new Object[][] {
                { "alibaba", 100f },
                { "xiaomi", 8f },
                { "jd", 33f }
        });
    }

    @Parameterized.Parameter(0)
    public String stock;

    @Parameterized.Parameter(1)
    public Float price;

    @Before
    public void before(){
        searchPage = App.toSearch();
    }

    @Test
    public void search(){
        assertThat(searchPage.search(stock).getCurrentPrice(), greaterThanOrEqualTo(price));
    }

    @After
    public void after(){
        //TODO:参数化完成之后需要点击取消按钮回到首页，再次传入参数···
        searchPage.cancel();
    }
}
