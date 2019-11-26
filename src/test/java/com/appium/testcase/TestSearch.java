package com.appium.testcase;

import com.appium.page.App;
import com.appium.page.SearchPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * @Author: Richered
 * @Date: 2019/11/16 23:28
 * @Description:测试搜索用例
 */
@RunWith(Parameterized.class)
public class TestSearch {
    public static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException{
        App.getInstance().start();
    }

    @Parameterized.Parameters
    public static Collection<Object> data() throws IOException {
//        List<String> stocks = new ArrayList<>();
//        stocks.add("xiaomi");
//        stocks.add("alibaba");
//        stocks.add("jd");
//        return stocks;
        //TODO:
//        return Arrays.asList(new Object[][] {
//                { "alibaba", 100f },
//                { "xiaomi", 8f },
//                { "jd", 33f }
//        });
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String path="/"+TestSearch.class.getCanonicalName().replace('.', '/')+".yaml";
        Object[][] demo = mapper.readValue(
                TestSearch.class.getResourceAsStream(path),
                Object[][].class);
        return Arrays.asList(demo);
    }

    @Parameterized.Parameter(0)
    public String stock;

    @Parameterized.Parameter(1)
    public Double price;

    @Before
    public void before(){
        searchPage = App.getInstance().toSearch();
    }

    @Test
    public void search(){
        assertThat(searchPage.search(stock).getCurrentPrice(), greaterThanOrEqualTo(price.floatValue()));
    }

    @After
    public void after(){
        //TODO:参数化完成之后需要点击取消按钮回到首页，再次传入参数···
        searchPage.cancel();
    }
}
